class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> dictionary = new HashSet<>(wordDict);
        boolean[] canWordBreakAtIndex = new boolean[n + 1];
        canWordBreakAtIndex[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                String suffix = s.substring(j, i);
                if (canWordBreakAtIndex[j] && dictionary.contains(suffix)) {
                    canWordBreakAtIndex[i] = true;
                }
            }
        }
        return canWordBreakAtIndex[n];
    }
}