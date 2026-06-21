class Solution {
    public String chooseSwap(String s) {
        int n = s.length();

        int[] first = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int curr = arr[i] - 'a';

            for (int j = 0; j < curr; j++) {
                if (first[j] > first[curr]) {
                    char c1 = arr[i];
                    char c2 = (char) (j + 'a');

                    for (int k = 0; k < n; k++) {
                        if (arr[k] == c1) {
                            arr[k] = c2;
                        } else if (arr[k] == c2) {
                            arr[k] = c1;
                        }
                    }
                    return new String(arr);
                }
            }
        }

        return s;
    }
}