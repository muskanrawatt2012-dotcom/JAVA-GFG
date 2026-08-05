class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return (int) (countAtMost(arr, r) - countAtMost(arr, l - 1));
    }

    private long countAtMost(int[] arr, long target) {
        long count = 0;
        long currentSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (left <= right && currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}