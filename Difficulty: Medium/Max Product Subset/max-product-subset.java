class Solution {
    public int findMaxProduct(int[] arr) {
        long mod = 1000000007L;
        int n = arr.length;

        if (n == 1) return arr[0];

        int negCount = 0, zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            } else if (x < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, x);
            }
        }

        if (zeroCount == n) return 0;

        if (negCount == 1 && negCount + zeroCount == n) return 0;

        long product = 1;

        for (int x : arr) {
            if (x == 0) continue;

            if ((negCount % 2 == 1) && x == maxNeg) {
                negCount = -1; 
                continue;
            }

            product = (product * x) % mod;
            product = (product + mod) % mod;
        }

        return (int) product;
    }
}