class Solution {
    public int sameMod(int[] arr) {
        int g = 0;
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[i - 1]));
        }

        if (g == 0) {
            return -1;
        }

        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                if (i * i == g) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}