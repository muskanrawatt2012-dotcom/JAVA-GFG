class Solution {
    private static final int MOD = 1_000_000_007;

    // 2D prefix sum helper: sum of ones in rectangle [r1..r2] x [c1..c2]
    private int rectSum(int r1, int c1, int r2, int c2, int[][] pref) {
        if (r1 > r2 || c1 > c2) return 0;
        return pref[r2 + 1][c2 + 1]
             - pref[r1][c2 + 1]
             - pref[r2 + 1][c1]
             + pref[r1][c1];
    }

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Build prefix sum
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = matrix[i][j]
                                   + pref[i][j + 1]
                                   + pref[i + 1][j]
                                   - pref[i][j];
            }
        }

        // down[r][c] = first row x >= r such that submatrix (r..x, c..m-1) has at least one 1
        // right[r][c] = first col y >= c such that submatrix (r..n-1, c..y) has at least one 1
        int[][] down = new int[n][m];
        int[][] right = new int[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int total = rectSum(r, c, n - 1, m - 1, pref);
                if (total == 0) {
                    down[r][c] = n;
                    right[r][c] = m;
                    continue;
                }

                // Binary search for first row with a 1
                int lo = r, hi = n - 1;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (rectSum(r, c, mid, m - 1, pref) > 0) hi = mid;
                    else lo = mid + 1;
                }
                down[r][c] = lo;

                // Binary search for first col with a 1
                lo = c; hi = m - 1;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (rectSum(r, c, n - 1, mid, pref) > 0) hi = mid;
                    else lo = mid + 1;
                }
                right[r][c] = lo;
            }
        }

        // dp for 1 piece: 1 if the remaining area has at least one 1, else 0
        long[][] prev = new long[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                prev[r][c] = rectSum(r, c, n - 1, m - 1, pref) > 0 ? 1 : 0;
            }
        }

        if (k == 1) return (int) prev[0][0];

        // Iterate for 2..k pieces
        for (int pieces = 2; pieces <= k; pieces++) {
            long[][] curr = new long[n][m];

            // Row suffix sums: rowSuf[r][c] = sum of prev[r'][c] for r' >= r
            long[][] rowSuf = new long[n + 1][m];
            for (int c = 0; c < m; c++) {
                rowSuf[n][c] = 0;
                for (int r = n - 1; r >= 0; r--) {
                    rowSuf[r][c] = (rowSuf[r + 1][c] + prev[r][c]) % MOD;
                }
            }

            // Col suffix sums: colSuf[r][c] = sum of prev[r][c'] for c' >= c
            long[][] colSuf = new long[n][m + 1];
            for (int r = 0; r < n; r++) {
                colSuf[r][m] = 0;
                for (int c = m - 1; c >= 0; c--) {
                    colSuf[r][c] = (colSuf[r][c + 1] + prev[r][c]) % MOD;
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    long ways = 0;

                    // Horizontal cut: cut after row x, where x >= down[r][c]
                    int firstRow = down[r][c];
                    if (firstRow < n - 1) {
                        ways += rowSuf[firstRow + 1][c];
                    }

                    // Vertical cut: cut after col y, where y >= right[r][c]
                    int firstCol = right[r][c];
                    if (firstCol < m - 1) {
                        ways += colSuf[r][firstCol + 1];
                    }

                    curr[r][c] = ways % MOD;
                }
            }

            prev = curr;
        }

        return (int) prev[0][0];
    }
}