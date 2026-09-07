import java.util.Arrays;

class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int maxVal = 101;

        int[][][] dp = new int[n + 1][maxVal + 1][maxVal + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                Arrays.fill(dp[i][j], 1000000);
            }
        }

        dp[0][0][101] = 0;

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            for (int inc = 0; inc <= maxVal; inc++) {
                for (int dec = 0; dec <= maxVal; dec++) {
                    if (dp[i][inc][dec] == 1000000) continue;

                    int currentCost = dp[i][inc][dec];

                    dp[i + 1][inc][dec] = Math.min(dp[i + 1][inc][dec], currentCost + 1);

                    if (val > inc) {
                        dp[i + 1][val][dec] = Math.min(dp[i + 1][val][dec], currentCost);
                    }

                    if (val < dec) {
                        dp[i + 1][inc][val] = Math.min(dp[i + 1][inc][val], currentCost);
                    }
                }
            }
        }

        int ans = 1000000;
        for (int inc = 0; inc <= maxVal; inc++) {
            for (int dec = 0; dec <= maxVal; dec++) {
                ans = Math.min(ans, dp[n][inc][dec]);
            }
        }

        return ans;
    }
}