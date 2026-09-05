class Solution {
    public int longestSubseq(int[] arr) {
        int maxLen = 0;
        int[] dp = new int[1000002];

        for (int num : arr) {
            int left = (num > 1) ? dp[num - 1] : 0;
            int right = dp[num + 1];

            dp[num] = Math.max(left, right) + 1;
            maxLen = Math.max(maxLen, dp[num]);
        }

        return maxLen;
    }
}