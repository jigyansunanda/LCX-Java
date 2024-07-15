class Solution {
    private ListNode currentHead;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.currentHead = head;
        int length = getLinkedListLength(head);
        return buildTreeInorder(0, length - 1);
    }

    private TreeNode buildTreeInorder( int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode leftChild = buildTreeInorder(l, m - 1);
        TreeNode root = new TreeNode(currentHead.val);
        root.left = leftChild;
        currentHead = currentHead.next;
        root.right = buildTreeInorder(m + 1, r);
        return root;
    }

    private int getLinkedListLength(ListNode head) {
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            ++length;
        }
        return length;
    }
}