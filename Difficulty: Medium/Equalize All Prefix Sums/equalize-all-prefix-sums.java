

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        long[] pref = new long[n];
        pref[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + arr[i];
        }
        
        for (int i = 0; i < n; i++) {
            int mid = i / 2;
            long median = arr[mid];
            
            long leftSum = pref[mid];
            long rightSum = pref[i] - pref[mid];
            
            long leftCost = median * (mid + 1) - leftSum;
            long rightCost = rightSum - median * (i - mid);
            
            ans.add((int)(leftCost + rightCost));
        }
        
        return ans;
    }
}