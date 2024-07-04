class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int startIndex = -1, maxLength = 0;
        for (int i = 0; i < n; i++) {
            int[] indices = getOddLengthPalindrome(s, i);
            int start = indices[0], end = indices[1];
            if (start != -1 && end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                startIndex = start;
            }
            indices = getEvenLengthPalindrome(s, i);
            start = indices[0];
            end = indices[1];
            if (start != -1 && end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                startIndex = start;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    private int[] getEvenLengthPalindrome(String s, int i) {
        int length = 0, start = i, end = i + 1;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
            length += 2;
        }
        return (length == 0) ? new int[]{-1, -1} : new int[]{start + 1, end - 1};
    }

    private int[] getOddLengthPalindrome(String s, int i) {
        int length = 0, start = i, end = i;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            length += (start == end) ? 1 : 2;
            --start;
            ++end;
        }
        return new int[]{start + 1, end - 1};
    }
}