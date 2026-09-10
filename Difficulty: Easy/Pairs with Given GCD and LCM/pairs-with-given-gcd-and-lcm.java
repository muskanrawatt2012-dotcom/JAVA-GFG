class Solution {
    public int pairCount(int x, int y) {
        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int distinctPrimes = 0;

        // Count distinct prime factors of k = y / x
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                distinctPrimes++;
                while (k % i == 0) {
                    k /= i;
                }
            }
        }

        // If remaining k is a prime number greater than 1
        if (k > 1) {
            distinctPrimes++;
        }

        // Each distinct prime factor prime power can be assigned to either 'a' or 'b' (2 choices each)
        return 1 << distinctPrimes;
    }
}