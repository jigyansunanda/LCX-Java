class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}