class Solution {
    private static final int MOD = 1000000007;

    public int palindromicStrings(int n, int k) {
        long total = 0;

        for (int len = 1; len <= n; len++) {
            int m = (len + 1) / 2;
            int evenPairs = len / 2;

            if (evenPairs > k) continue;

            if (len % 2 == 0) {
                total = (total + nPr(k, m)) % MOD;
            } else {
                long count = (long) k * nPr(k - 1, m - 1) % MOD;
                total = (total + count) % MOD;
            }
        }

        return (int) total;
    }

    private long nPr(int n, int r) {
        if (r < 0 || r > n) return 0;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = (result * (n - i)) % MOD;
        }
        return result;
    }
}