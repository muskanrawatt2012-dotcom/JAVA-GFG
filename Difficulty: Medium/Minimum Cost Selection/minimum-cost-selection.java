class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;
        int[] prev = new int[3];
        prev[0] = mat[0][0];
        prev[1] = mat[0][1];
        prev[2] = mat[0][2];
        for (int i = 1; i < n; i++) {
            int[] curr = new int[3];
            curr[0] = mat[i][0] + Math.min(prev[1], prev[2]);
            curr[1] = mat[i][1] + Math.min(prev[0], prev[2]);
            curr[2] = mat[i][2] + Math.min(prev[0], prev[1]);
            prev = curr;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}