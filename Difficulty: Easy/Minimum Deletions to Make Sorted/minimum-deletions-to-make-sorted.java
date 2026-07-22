import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {

            int idx = Collections.binarySearch(lis, num);
            
          
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            
            if (idx == lis.size()) {
                lis.add(num);
            } else {
lis.set(idx, num);
            }
        }
        

        return n - lis.size();
    }
}