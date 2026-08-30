import java.util.*;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (r[i] - l[i] + 1L);
        }

        ArrayList<Integer> res = new ArrayList<>(rank.length);
        for (int q : rank) {
            int pos = Arrays.binarySearch(pref, q);
            if (pos < 0) pos = -pos - 1;
            int idx = pos - 1;
            int offset = (int)(q - pref[idx]);
            res.add(l[idx] + offset - 1);
        }
        return res;
    }
}