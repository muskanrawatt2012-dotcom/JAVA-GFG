class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        int[] moves = new int[target + 1];

        for (int i = 0; i < lad.length; i += 2) {
            moves[lad[i]] = lad[i + 1];
        }
        for (int i = 0; i < sn.length; i += 2) {
            moves[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[target + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cell = current[0];
            int dist = current[1];

            if (cell == target) {
                return dist;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cell + i;
                if (next > target) break;

                if (moves[next] != 0) {
                    next = moves[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, dist + 1});
                }
            }
        }

        return -1;
    }
}