

class Solution {
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        int[] maxPrimePower = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1;
                    cycleLength++;
                }

                int temp = cycleLength;
                for (int p = 2; p * p <= temp; p++) {
                    if (temp % p == 0) {
                        int power = 1;
                        while (temp % p == 0) {
                            power *= p;
                            temp /= p;
                        }
                        maxPrimePower[p] = Math.max(maxPrimePower[p], power);
                    }
                }
                if (temp > 1) {
                    maxPrimePower[temp] = Math.max(maxPrimePower[temp], temp);
                }
            }
        }

        long ans = 1;
        long mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            if (maxPrimePower[i] > 0) {
                ans = (ans * maxPrimePower[i]) % mod;
            }
        }

        return (int) ans;
    }
}