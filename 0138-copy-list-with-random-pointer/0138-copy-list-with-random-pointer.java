class Solution {
    /* Time Complexity: O(N)
       Space Complexity: O(N)
     */
    public Node copyRandomList_NaiveApproach(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        // Create new copy of same node and
        // put it in a hashmap <node, copy>
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        // Assign next and random pointers using
        // pointer addresses from the hashmap
        node = head;
        while (node != null) {
            if (node.next != null) map.get(node).next = map.get(node.next);
            if (node.random != null) map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }



    /* Time Complexity: O(N)
       Space Complexity: O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // create copy node after the node itself
        Node node = head;
        while (node != null) {
            Node nextNode = node.next;
            node.next = new Node(node.val);
            node.next.next = nextNode;
            node = nextNode;
        }
        // duplicate random pointers
        node = head;
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        // remove the copy list and return
        Node copy = null, copyTail = null;
        Node curr = head;
        while (curr != null) {
            if (copy == null) {
                copy = curr.next;
                copyTail = curr.next;
            } else {
                copyTail.next = curr.next;
                copyTail = copyTail.next;
            }
            curr.next = curr.next.next;
            curr = curr.next;
        }
        if (copyTail != null) copyTail.next = null;
        return copy;
    }
}