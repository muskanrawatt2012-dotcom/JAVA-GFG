class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
            leftMax[i] = maxSoFar;
        }
        
        int minSoFar = arr[0];
        int currentMin = arr[0];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSoFar = Math.min(minSoFar, currentMin);
            leftMin[i] = minSoFar;
        }
        
        maxSoFar = arr[n - 1];
        currentMax = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
            rightMax[i] = maxSoFar;
        }
        
        minSoFar = arr[n - 1];
        currentMin = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSoFar = Math.min(minSoFar, currentMin);
            rightMin[i] = minSoFar;
        }
        
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff1 = Math.abs(leftMax[i] - rightMin[i + 1]);
            int diff2 = Math.abs(leftMin[i] - rightMax[i + 1]);
            maxDiff = Math.max(maxDiff, Math.max(diff1, diff2));
        }
        
        return maxDiff;
    }
}