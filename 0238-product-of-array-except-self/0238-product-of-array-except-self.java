class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int productFromRight = 1;
        for (int i = n - 1; i >= 0; --i) {
            int currentElement = nums[i];
            nums[i] = productFromRight * left[i];
            productFromRight *= currentElement;
        }
        return nums;
    }
}