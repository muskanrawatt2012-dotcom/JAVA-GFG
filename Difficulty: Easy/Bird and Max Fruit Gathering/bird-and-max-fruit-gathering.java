class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if (m >= n) {
            int total = 0;
            for (int val : arr) {
                total += val;
            }
            return total;
        }

        long currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }

        long maxSum = currentSum;

        for (int i = 0; i < n; i++) {
            currentSum -= arr.get(i);
            currentSum += arr.get((i + m) % n);
            maxSum = Math.max(maxSum, currentSum);
        }

        return (int) maxSum;
    }
}