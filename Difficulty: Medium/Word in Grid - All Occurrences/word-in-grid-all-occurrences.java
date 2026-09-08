class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == word.charAt(0)) {
                    if (searchIn8Directions(mat, word, r, c, dx, dy)) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(r);
                        pos.add(c);
                        result.add(pos);
                    }
                }
            }
        }

        return result;
    }

    private boolean searchIn8Directions(char[][] mat, String word, int row, int col, int[] dx, int[] dy) {
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k;
            int currRow = row;
            int currCol = col;

            for (k = 0; k < len; k++) {
                if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= m) {
                    break;
                }

                if (mat[currRow][currCol] != word.charAt(k)) {
                    break;
                }

                currRow += dx[dir];
                currCol += dy[dir];
            }

            if (k == len) {
                return true;
            }
        }

        return false;
    }
}