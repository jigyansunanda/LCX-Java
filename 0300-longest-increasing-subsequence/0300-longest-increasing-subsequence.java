class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // dp[i]: minimum possible element you can
        // have as the ending value of an increasing
        // subsequence of length (i + 1)
        dp[0] = nums[0];
        int maxLength = 1;
        for (int i = 1; i < n; ++i) {
            int index = findIndex(dp, maxLength, nums[i]);
            if (index == maxLength) {
                dp[index] = nums[i];
                ++maxLength;
            } else {
                dp[index] = Math.min(dp[index], nums[i]);
            }
        }
        return maxLength;
    }

    private int findIndex(int[] dp, int maxLength, int num) {
        int lo = -1, hi = maxLength;
        while (hi > lo + 1) {
            int mid = (lo + hi) >> 1;
            if (dp[mid] < num) lo = mid;
            else hi = mid;
        }
        return lo + 1;
    }
}