import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        int[][] count = new int[n][n];
        int[][] maxVal = new int[n][n];

        count[0][0] = 1;
        maxVal[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0) {
                    continue;
                }

                int val = grid[i][j];

                if ((val == 1 || val == 3) && j + 1 < n) {
                    count[i][j + 1] = (count[i][j + 1] + count[i][j]) % MOD;
                    maxVal[i][j + 1] = Math.max(maxVal[i][j + 1], maxVal[i][j] + grid[i][j + 1]);
                }

                if ((val == 2 || val == 3) && i + 1 < n) {
                    count[i + 1][j] = (count[i + 1][j] + count[i][j]) % MOD;
                    maxVal[i + 1][j] = Math.max(maxVal[i + 1][j], maxVal[i][j] + grid[i + 1][j]);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count[n - 1][n - 1]);
        result.add(maxVal[n - 1][n - 1]);

        return result;
    }
}