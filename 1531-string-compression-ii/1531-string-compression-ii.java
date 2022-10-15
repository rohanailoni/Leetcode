public class Solution {
    private final int[][] dp = new int[101][101];

    public int getLengthOfOptimalCompression(String s, int k) {
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return helper(s, 0, k);
    }

    private int helper(String s, int left, int k) {
        int n = k;
        if (s.length() - left <= n) return 0;
        if (dp[left][n] > -1) return dp[left][n];
        int res = (n > 0) ? helper(s, left + 1, n - 1) : 10000, c = 1;
        for (int i = left + 1; i <= s.length(); i++) {
            res = Math.min(res, helper(s, i, n) + 1 + helper(c));
            if (i == s.length()) break;
            if (s.charAt(i) == s.charAt(left)) ++c;
            else if (--n < 0) break;
        }
        return dp[left][k] = res;
    }

    private int helper(int c) {
        if (c >= 100) return 3;
        if (c >= 10) return 2;
        if (c > 1) return 1;
        return 0;
    }
}
