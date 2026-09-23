class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int[] L = new int[n];
        int[] R = new int[n];

        // Left-to-right pass
        L[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            L[i] = Math.min(arr[i], L[i - 1] + 1);
        }

        // Right-to-left pass
        R[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.min(arr[i], R[i + 1] + 1);
        }

        // Find maximum valid peak height
        int maxPeak = 0;
        for (int i = 0; i < n; i++) {
            maxPeak = Math.max(maxPeak, Math.min(L[i], R[i]));
        }

        long pyramidSum = (long) maxPeak * maxPeak;
        return (int) (totalSum - pyramidSum);
    }
}