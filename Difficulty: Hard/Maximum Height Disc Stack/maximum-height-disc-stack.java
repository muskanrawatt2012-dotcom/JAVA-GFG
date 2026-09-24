import java.util.Arrays;

class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int[][] discs = new int[n][2];
        int maxH = 0;

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
            if (h[i] > maxH) {
                maxH = h[i];
            }
        }

        Arrays.sort(discs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        int[] bit = new int[maxH + 1];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int height = discs[i][1];
            int maxPrev = query(bit, height - 1);
            int currentMax = maxPrev + height;
            ans = Math.max(ans, currentMax);
            update(bit, height, currentMax);
        }

        return ans;
    }

    private void update(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] = Math.max(bit[idx], val);
            idx += idx & -idx;
        }
    }

    private int query(int[] bit, int idx) {
        int maxVal = 0;
        while (idx > 0) {
            maxVal = Math.max(maxVal, bit[idx]);
            idx -= idx & -idx;
        }
        return maxVal;
    }
}