class Solution {
    public int count(int n, int m) {
        // dp[i][j] stores the number of valid sequences of length i ending with number j
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case: For a sequence of length 1, each number from 1 to m can form exactly 1 sequence
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }
        
        // Fill the DP table for lengths from 2 to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    // Check if adjacent elements divide each other
                    if (j % k == 0 || k % j == 0) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }
        
        // Sum up all valid sequences of length n ending with any number from 1 to m
        int totalSequences = 0;
        for (int j = 1; j <= m; j++) {
            totalSequences += dp[n][j];
        }
        
        return totalSequences;
    }
}