import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        int[] far1 = bfs(1, adj, n);
        int[] far2 = bfs(far1[0], adj, n);

        return (far2[1] + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;

        int maxNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (dist[u] > maxDist) {
                maxDist = dist[u];
                maxNode = u;
            }

            for (int v : adj.get(u - 1)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        return new int[]{maxNode, maxDist};
    }
}