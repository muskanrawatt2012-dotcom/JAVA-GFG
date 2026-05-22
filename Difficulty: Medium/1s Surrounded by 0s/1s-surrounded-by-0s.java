class Solution {
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid, vis);
            if (grid[i][m - 1] == 1) dfs(i, m - 1, grid, vis);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid, vis);
            if (grid[n - 1][j] == 1) dfs(n - 1, j, grid, vis);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) return;
        if (grid[r][c] == 0 || vis[r][c]) return;

        vis[r][c] = true;

        dfs(r + 1, c, grid, vis);
        dfs(r - 1, c, grid, vis);
        dfs(r, c + 1, grid, vis);
        dfs(r, c - 1, grid, vis);
    }
}