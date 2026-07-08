

class Solution {
    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] reachableP = new boolean[n][m];
        boolean[][] reachableQ = new boolean[n][m];

        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queueP.add(new int[]{i, 0});
            reachableP[i][0] = true;
            
            queueQ.add(new int[]{i, m - 1});
            reachableQ[i][m - 1] = true;
        }

        for (int j = 0; j < m; j++) {
            queueP.add(new int[]{0, j});
            reachableP[0][j] = true;
            
            queueQ.add(new int[]{n - 1, j});
            reachableQ[n - 1][j] = true;
        }

        bfs(mat, queueP, reachableP, n, m);
        bfs(mat, queueQ, reachableQ, n, m);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachableP[i][j] && reachableQ[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int[][] mat, Queue<int[]> queue, boolean[][] reachable, int n, int m) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !reachable[nr][nc]) {
                    if (mat[nr][nc] >= mat[r][c]) {
                        reachable[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}