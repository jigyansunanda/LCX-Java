class Solution {
    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        DFS(root);
        return maxPathSum;
    }

    private int DFS(TreeNode root) {
        if (root == null) return 0;
        int leftPathSum = DFS(root.left);
        int rightPathSum = DFS(root.right);
        int twoDirectionalPathSum = leftPathSum + rightPathSum + root.val;
        int maxOneDirectionalPathSum = Math.max(root.val, root.val + Math.max(leftPathSum, rightPathSum));
        maxPathSum = Math.max(maxPathSum, Math.max(twoDirectionalPathSum, maxOneDirectionalPathSum));
        return maxOneDirectionalPathSum;
    }
}