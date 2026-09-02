class Solution {
    public int solve(int n, String s) {
        int[] status = new int[26];
        int occupied = 0;
        int unassignedCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int customer = s.charAt(i) - 'A';

            if (status[customer] == 0) {
                if (occupied < n) {
                    status[customer] = 1;
                    occupied++;
                } else {
                    status[customer] = 2;
                    unassignedCount++;
                }
            } else if (status[customer] == 1) {
                status[customer] = 0;
                occupied--;
            }
        }

        return unassignedCount;
    }
}