

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        if (solveMaze(0, 0, mat, ans, memo, n)) {
            return convertToArrayList(ans);
        }
        
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        noPath.add(row);
        return noPath;
    }
    
    private boolean solveMaze(int r, int c, int[][] mat, int[][] ans, int[][] memo, int n) {
        if (r == n - 1 && c == n - 1) {
            ans[r][c] = 1;
            return true;
        }
        
        if (!isValid(r, c, n) || mat[r][c] == 0) {
            return false;
        }
        
        if (memo[r][c] == 0) {
            return false;
        }
        
        ans[r][c] = 1;
        
        for (int jump = 1; jump <= mat[r][c]; jump++) {
            if (solveMaze(r, c + jump, mat, ans, memo, n)) {
                return true;
            }
            if (solveMaze(r + jump, c, mat, ans, memo, n)) {
                return true;
            }
        }
        
        ans[r][c] = 0;
        memo[r][c] = 0; 
        return false;
    }
    
    private boolean isValid(int r, int c, int n) {
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
    
    private ArrayList<ArrayList<Integer>> convertToArrayList(int[][] ans) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] row : ans) {
            ArrayList<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            result.add(listRow);
        }
        return result;
    }
}