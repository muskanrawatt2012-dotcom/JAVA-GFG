class Solution {
    static final long MOD = 1000000007L;

    public int computeValue(int n) {
        int N = 2 * n;

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[N] = modPow(fact[N], MOD - 2);

        for (int i = N; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }

        long ans = fact[N];
        ans = (ans * invFact[n]) % MOD;
        ans = (ans * invFact[n]) % MOD;

        return (int) ans;
    }

    private long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}