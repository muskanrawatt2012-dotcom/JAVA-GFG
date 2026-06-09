class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {

        int n = seats.length;

       
        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {

                int left = (i == 0) ? 0 : seats[i - 1];
                int right = (i == n - 1) ? 0 : seats[i + 1];

                if (left == 0 && right == 0) {
                    seats[i] = 1;
                    count++;
                }
            }
        }

        return count >= k;
    }
}