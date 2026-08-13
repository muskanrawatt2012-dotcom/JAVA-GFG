import java.util.*;

class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    if (dist[u] + w > dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        return dist;
    }

    private void topoSort(int node, ArrayList<ArrayList<int[]>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int[] neighbor : adj.get(node)) {
            int nextNode = neighbor[0];
            if (!visited[nextNode]) {
                topoSort(nextNode, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}