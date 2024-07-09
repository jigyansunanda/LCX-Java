class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        final int MASK = (1 << n) - 1;
        for (int i = 0; i <= MASK; ++i) {
            List<Integer> subans = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    subans.add(nums[j]);
                }
            }
            ans.add(subans);
        }
        return ans;
    }
}