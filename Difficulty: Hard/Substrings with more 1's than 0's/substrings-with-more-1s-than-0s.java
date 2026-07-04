class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int[] bit = new int[2 * n + 2];
        int sum = n + 1;
        update(bit, sum, 1);
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                sum--;
            }
            count += query(bit, sum - 1);
            update(bit, sum, 1);
        }
        
        return count;
    }

    private void update(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    private int query(int[] bit, int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}