class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int bestNum = n;
        int maxSum = getDigitSum(n);

        long currentPrefix = 0;
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';

            if (digit > 0) {
                long candidate = currentPrefix * 10 + (digit - 1);
                for (int j = i + 1; j < len; j++) {
                    candidate = candidate * 10 + 9;
                }

                if (candidate >= 1 && candidate <= n) {
                    int candSum = getDigitSum(candidate);
                    if (candSum > maxSum || (candSum == maxSum && candidate > bestNum)) {
                        maxSum = candSum;
                        bestNum = (int) candidate;
                    }
                }
            }

            currentPrefix = currentPrefix * 10 + digit;
        }

        return bestNum;
    }

    private int getDigitSum(long num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}