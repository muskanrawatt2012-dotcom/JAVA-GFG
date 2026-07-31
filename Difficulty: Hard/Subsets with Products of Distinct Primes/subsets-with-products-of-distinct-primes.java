class Solution {
    public int countSubsets(int[] arr) {
        int MOD = 1_000_000_007;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] count = new int[31];
        
        for (int num : arr) {
            count[num]++;
        }
        
        // dp[mask] stores the number of valid subsets with the prime composition 'mask'
        long[] dp = new long[1024];
        dp[0] = 1; // Base case: empty subset
        
        // Iterate through all possible numbers from 2 to 30
        for (int i = 2; i <= 30; i++) {
            if (count[i] == 0) continue;
            
            // Check if the number contains any duplicate prime factors (e.g., divisible by 4, 9, 25)
            if (i % 4 == 0 || i % 9 == 0 || i % 25 == 0) continue;
            
            // Generate the prime mask for current number 'i'
            int currentMask = 0;
            for (int p = 0; p < 10; p++) {
                if (i % primes[p] == 0) {
                    currentMask |= (1 << p);
                }
            }
            
            // Update the DP table backwards to avoid using the same number instance multiple times
            for (int mask = 1023; mask >= 0; mask--) {
                // If the current number shares prime factors with the existing subset mask, skip
                if ((mask & currentMask) == 0) {
                    dp[mask | currentMask] = (dp[mask | currentMask] + dp[mask] * count[i]) % MOD;
                }
            }
        }
        
        // Sum up all valid non-empty subsets
        long totalSubsets = 0;
        for (int mask = 1; mask < 1024; mask++) {
            totalSubsets = (totalSubsets + dp[mask]) % MOD;
        }
        
        // Handle the number of 1s: each '1' can either be included or excluded (2^count[1] options)
        long pow2 = 1;
        for (int i = 0; i < count[1]; i++) {
            pow2 = (pow2 * 2) % MOD;
        }
        
        return (int) ((totalSubsets * pow2) % MOD);
    }
}