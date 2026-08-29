class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] ndp = new int[n];

        for (char ch : s.toCharArray()) {
            int d = ch - '0';
            System.arraycopy(dp, 0, ndp, 0, n);
            for (int r = 0; r < n; r++) {
                int val = dp[r];
                if (val == 0) continue;
                int nr = (r * 10 + d) % n;
                int sum = ndp[nr] + val;
                if (sum >= MOD) sum -= MOD;
                ndp[nr] = sum;
            }
            int[] tmp = dp;
            dp = ndp;
            ndp = tmp;
        }

        int ans = dp[0] - 1;
        if (ans < 0) ans += MOD;
        return ans;
    }
}