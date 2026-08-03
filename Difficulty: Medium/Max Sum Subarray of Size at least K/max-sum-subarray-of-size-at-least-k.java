class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        
        int[] maxSum = new int[n];
        int currSum = arr[0];
        maxSum[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum[i] = currSum;
        }
        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int ans = windowSum;
        
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            ans = Math.max(ans, windowSum);
            ans = Math.max(ans, windowSum + maxSum[i - k]);
        }
        
        return ans;
    }
}