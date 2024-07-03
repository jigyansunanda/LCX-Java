/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*
 * Note: Perfect Binary Tree with every parents having
 * two children and all leaf nodes on same level
 */
class Solution {
    public Node connect(Node root) {
        Node startNodeOfLevel = root;
        while (startNodeOfLevel != null) {
            Node currentNode = startNodeOfLevel;
            while (currentNode != null) {
                if (currentNode.left != null) currentNode.left.next = currentNode.right;
                if (currentNode.right != null && currentNode.next != null)
                    currentNode.right.next = currentNode.next.left;
                currentNode = currentNode.next;
            }
            startNodeOfLevel = startNodeOfLevel.left;
        }
        return root;
    }
}