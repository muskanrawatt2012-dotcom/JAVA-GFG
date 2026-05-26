class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;
        int ans = n;

        for (int i = 0; i <= n; i++) {
            int toggles = 0;

            for (int j = 0; j < n; j++) {
                if (j < i) {
                    if (arr[j] != 0) toggles++;
                } else {
                    if (arr[j] != 1) toggles++;
                }
            }

            ans = Math.min(ans, toggles);
        }

        return ans;
    }
}