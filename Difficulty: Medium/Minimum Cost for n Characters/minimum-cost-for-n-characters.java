import java.util.*;

class Solution {
    private Map<Integer, Long> memo;
    private int n, i, d, c;

    public int minCost(int n, int i, int d, int c) {
        this.n = n;
        this.i = i;
        this.d = d;
        this.c = c;
        this.memo = new HashMap<>();
        return (int) solve(n);
    }

    private long solve(int x) {
        if (x == 0) return 0;
        if (x < 0) return Long.MAX_VALUE / 2;
        if (memo.containsKey(x)) return memo.get(x);

        long ans = (long) i * x;
        int half = x / 2;
        int range = 10;
        int start = Math.max(0, half - range);
        int end = Math.min(half + range, x - 1);

        for (int a = start; a <= end; a++) {
            int y = 2 * a;
            long move;
            if (y <= x) {
                move = (long) (x - y) * i;
            } else {
                move = (long) (y - x) * d;
            }
            long candidate = solve(a) + c + move;
            if (candidate < ans) ans = candidate;
        }

        memo.put(x, ans);
        return ans;
    }
}