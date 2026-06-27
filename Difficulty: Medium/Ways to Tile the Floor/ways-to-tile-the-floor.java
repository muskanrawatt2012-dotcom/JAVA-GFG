class Solution {
    public int countWays(int n, int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }

        int[] dp = new int[n + 1];
        int MOD = 1000000007;

        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
            }
        }

        return dp[n];
    }
}