import java.util.Arrays;

class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        return countTripletsLessThanOrEqual(arr, r) - countTripletsLessThanOrEqual(arr, l - 1);
    }

    private int countTripletsLessThanOrEqual(int[] arr, int val) {
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum <= val) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}