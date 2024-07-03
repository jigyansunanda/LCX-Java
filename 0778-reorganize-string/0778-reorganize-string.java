class Solution {
    public String reorganizeString(String s) {
        int n = s.length(), maxCount = 0, maxIndex = -1;
        int[] charCount = new int[26];
        for (int i = 0; i < n; ++i) {
            int index = s.charAt(i) - 'a';
            charCount[index]++;
            if (charCount[index] > maxCount) {
                maxCount = charCount[index];
                maxIndex = index;
            }
            if (maxCount > (n + 1) / 2) return "";
        }
        char[] ans = new char[n];
        int index = 0;
        while (charCount[maxIndex] > 0) {
            ans[index] = (char) ('a' + maxIndex);
            index += 2;
            charCount[maxIndex]--;
        }
        for (int i = 0; i < 26; ++i) {
            while (charCount[i] != 0) {
                if (index >= n) index = 1;
                ans[index] = (char) ('a' + i);
                index += 2;
                charCount[i]--;
            }
        }
        return new String(ans);
    }
}