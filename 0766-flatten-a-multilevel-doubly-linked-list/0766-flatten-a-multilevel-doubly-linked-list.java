/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node tail = head;
        while (tail != null) {
            Node next = tail.next;
            if (tail.child != null) {
                Node flattenedHead = flatten(tail.child);
                Node flattenedTail = getTail(flattenedHead);
                tail.child = null;

                tail.next = flattenedHead;
                flattenedHead.prev = tail;

                flattenedTail.next = next;
                if (next != null) next.prev = flattenedTail;
            }
            tail = next;
        }
        return head;
    }

    private Node getTail(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}