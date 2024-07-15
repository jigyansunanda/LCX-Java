class Solution {
    final static int MAX = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;

        // assumption: m < n => time complexity: O(log m)
        if (m > n) return findMedianSortedArrays(B, A);

        // if odd, return middle else return average of middles
        boolean isOdd = ((m + n) % 2) == 1;

        if (A.length == 0) {
            if (n % 2 == 0)
                return ((double) B[n / 2] + B[(n / 2) - 1]) / 2.0;
            else
                return B[n / 2];
        }
        // Fact: m <= n, hence B.length can not be 0

        int l = -1, r = m;
        while (l <= r) {
            int indexInFirstArray = (l + r) / 2;
            int indexInSecondArray = ((m + n + 1) / 2) - (indexInFirstArray + 1) - 1;

            int maxInFirst = (indexInFirstArray < 0) ? MIN : A[indexInFirstArray];
            int minInFirst = (indexInFirstArray + 1 == m) ? MAX : A[indexInFirstArray + 1];

            int maxInSecond = (indexInSecondArray < 0) ? MIN : B[indexInSecondArray];
            int minInSecond = (indexInSecondArray + 1 == n) ? MAX : B[indexInSecondArray + 1];

            if (maxInFirst <= minInSecond && maxInSecond <= minInFirst) {
                if (isOdd) {
                    return (double) Math.max(maxInFirst, maxInSecond);
                } else {
                    return ((double) (Math.max(maxInFirst, maxInSecond) + Math.min(minInFirst, minInSecond))) / 2.0;
                }
            } else if (maxInFirst > minInSecond) {
                r = indexInFirstArray - 1;
            }
            // maxInSecond > minInFirst
            else {
                l = indexInFirstArray + 1;
            }
        }
        // Fact: m <= n
        if (A[m - 1] <= B[0]) {
            if (m == n)
                return ((double) A[m - 1] + B[0]) / 2.0;
            else {
                int index = ((m + n + 1) / 2) - m;
                if (isOdd)
                    return (double) B[index - 1];
                else
                    return ((double) B[index - 1] + B[index - 2]) / 2.0;
            }
        }
        if (B[n - 1] <= A[0]) {
            if (m == n) return ((double) B[n - 1] + A[0]) / 2.0;
            // n > m
            else {
                int index = ((m + n + 1) / 2);
                if (isOdd)
                    return (double) B[index - 1];
                else
                    return ((double) B[index - 1] + B[index]) / 2.0;
            }
        }
        return -1;
    }
}