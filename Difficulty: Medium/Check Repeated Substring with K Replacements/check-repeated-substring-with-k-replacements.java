class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();

        if (n % k != 0)
            return false;

        int blocks = n / k;
        String[] arr = new String[blocks];

        for (int i = 0; i < blocks; i++) {
            arr[i] = s.substring(i * k, (i + 1) * k);
        }

        String candidate1 = arr[0];
        int diff1 = 0;

        for (String str : arr) {
            if (!str.equals(candidate1))
                diff1++;
        }

        if (diff1 <= 1)
            return true;

        String candidate2 = null;
        for (String str : arr) {
            if (!str.equals(candidate1)) {
                candidate2 = str;
                break;
            }
        }

        int diff2 = 0;
        for (String str : arr) {
            if (!str.equals(candidate2))
                diff2++;
        }

        return diff2 <= 1;
    }
}