class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0};
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);
        return Math.max(left, right) + 1;
    }
}