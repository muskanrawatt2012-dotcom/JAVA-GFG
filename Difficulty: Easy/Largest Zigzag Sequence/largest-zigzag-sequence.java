class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        if (n == 1) return mat[0][0];

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1, max2 = -1;
            int max1Col = -1;

            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] > max1) {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                    max1Col = j;
                } else if (dp[i - 1][j] > max2) {
                    max2 = dp[i - 1][j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (j != max1Col) {
                    dp[i][j] = mat[i][j] + max1;
                } else {
                    dp[i][j] = mat[i][j] + max2;
                }
            }
        }

        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }

        return maxSum;
    }
}