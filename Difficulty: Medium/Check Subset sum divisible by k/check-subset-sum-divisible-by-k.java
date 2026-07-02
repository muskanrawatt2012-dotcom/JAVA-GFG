class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;
        if (n > k) {
            return true;
        }

        boolean[] dp = new boolean[k];

        for (int num : arr) {
            int rem = num % k;
            if (rem == 0) {
                return true;
            }

            boolean[] nextDp = new boolean[k];
            for (int i = 0; i < k; i++) {
                if (dp[i]) {
                    nextDp[i] = true;
                    nextDp[(i + rem) % k] = true;
                }
            }
            nextDp[rem] = true;

            if (nextDp[0]) {
                return true;
            }
            dp = nextDp;
        }

        return false;
    }
}