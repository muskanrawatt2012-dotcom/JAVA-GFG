class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        int noDeletionMax = arr[0];
        int oneDeletionMax = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {
            oneDeletionMax = Math.max(noDeletionMax, oneDeletionMax + arr[i]);
            noDeletionMax = Math.max(arr[i], noDeletionMax + arr[i]);
            overallMax = Math.max(overallMax, Math.max(noDeletionMax, oneDeletionMax));
        }

        return overallMax;
    }
}