class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int[] dp = new int[n + 1];

        for (int x : arr) {
            dp[x] = dp[x - 1] + 1;
            if (dp[x] > maxLen) {
                maxLen = dp[x];
            }
        }

        return n - maxLen;
    }
}