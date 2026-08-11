import java.util.ArrayList;

class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];
            int maxD = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));
            int low = 0, high = maxD;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int r1 = r - mid, c1 = c - mid;
                int r2 = r + mid, c2 = c + mid;
                int sum = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];

                if (sum <= k) {
                    ans = 2 * mid + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            result.add(ans);
        }

        return result;
    }
}