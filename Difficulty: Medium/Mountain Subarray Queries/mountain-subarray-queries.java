import java.util.ArrayList;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }
        
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        
        ArrayList<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            
            if (right[l] >= left[r]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}