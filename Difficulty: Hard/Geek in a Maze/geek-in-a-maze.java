import java.util.*;

class Solution {
    static class Node {
        int r, c, u, d;

        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] == '#') {
            return 0;
        }

        int[][] maxUp = new int[n][m];
        int[][] maxDown = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxUp[i], -1);
            Arrays.fill(maxDown[i], -1);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, u, d));
        maxUp[r][c] = u;
        maxDown[r][c] = d;

        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                int nu = curr.u;
                int nd = curr.d;

                if (i == 0) nu--;
                if (i == 1) nd--;

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == '.' && nu >= 0 && nd >= 0) {
                    if (nu > maxUp[nr][nc] || nd > maxDown[nr][nc]) {
                        if (nu > maxUp[nr][nc]) maxUp[nr][nc] = nu;
                        if (nd > maxDown[nr][nc]) maxDown[nr][nc] = nd;
                        q.add(new Node(nr, nc, nu, nd));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maxUp[i][j] != -1) {
                    count++;
                }
            }
        }

        return count;
    }
}