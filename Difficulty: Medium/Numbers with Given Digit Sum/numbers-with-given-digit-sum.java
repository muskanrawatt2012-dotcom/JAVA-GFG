class Solution {
    public int countWays(int n, int sum) {
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }
        
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                for (int digit = 0; digit <= 9; digit++) {
                    if (i == 1 && digit == 0) {
                        continue;
                    }
                    if (j >= digit) {
                        dp[i][j] += dp[i - 1][j - digit];
                    }
                }
            }
        }
        
        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}