class Solution {
    public int countWithout(int n, int d) {
        if (n <= 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();
        int count = 0;
        boolean hasD = false;

        for (int i = 0; i < len; i++) {
            int currentDigit = s.charAt(i) - '0';
            int remainingDigits = len - 1 - i;

            int validChoices = 0;
            for (int digit = 0; digit < currentDigit; digit++) {
                if (digit == 0 && i == 0) {
                    continue; // Skip leading zero for the highest digit
                }
                if (digit != d) {
                    validChoices++;
                }
            }

            int multiplier = (d == 0) ? (int) Math.pow(9, remainingDigits) : (int) Math.pow(9, remainingDigits);
            count += validChoices * (d == 0 ? (int) Math.pow(9, remainingDigits) : (int) Math.pow(9, remainingDigits));

            if (currentDigit == d) {
                hasD = true;
                break;
            }
        }

        if (!hasD) {
            count++; // Count n itself if valid
        }

        // Add numbers with fewer digits than n
        for (int i = 1; i < len; i++) {
            if (d == 0) {
                count += 9 * Math.pow(9, i - 1);
            } else {
                count += 8 * Math.pow(9, i - 1);
            }
        }

        return count;
    }
}