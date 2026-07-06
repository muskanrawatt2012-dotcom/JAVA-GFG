class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        int sumA = 0, sumB = 0;
        int totalSum = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                sumA += a[i++];
            } else if (a[i] > b[j]) {
                sumB += b[j++];
            } else {
                totalSum += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sumA += a[i++];
        }

        while (j < n) {
            sumB += b[j++];
        }

        totalSum += Math.max(sumA, sumB);

        return totalSum;
    }
}