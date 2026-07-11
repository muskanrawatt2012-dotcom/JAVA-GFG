class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        return maxLength(mat, xs, ys, xd, yd);
    }

    private int maxLength(int[][] mat, int x, int y, int xd, int yd) {
        if (x == xd && y == yd) {
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;
        int maxDist = -1;

        mat[x][y] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && mat[nx][ny] == 1) {
                int res = maxLength(mat, nx, ny, xd, yd);
                if (res != -1) {
                    maxDist = Math.max(maxDist, res + 1);
                }
            }
        }

        mat[x][y] = 1;
        return maxDist;
    }
}