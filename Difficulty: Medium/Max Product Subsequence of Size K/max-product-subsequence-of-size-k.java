import java.util.Arrays;

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        if (arr[n - 1] <= 0 && k % 2 != 0) {
            int prod = 1;
            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }
            return prod;
        }

        int prod = 1;
        int i = 0, j = n - 1;

        while (k > 0) {
            if (k == 1) {
                prod *= arr[j];
                j--;
                k--;
            } else {
                if (arr[i] * arr[i + 1] > arr[j] * arr[j - 1]) {
                    prod *= arr[i] * arr[i + 1];
                    i += 2;
                    k -= 2;
                } else {
                    prod *= arr[j];
                    j--;
                    k--;
                }
            }
        }

        return prod;
    }
}