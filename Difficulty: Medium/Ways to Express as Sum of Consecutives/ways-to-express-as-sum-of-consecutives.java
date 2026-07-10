class Solution {
    public int getCount(int n) {
        int count = 0;
        long k = 2;
        
        while (true) {
            long shift = (k * (k - 1)) / 2;
            if (shift >= n) {
                break;
            }
            if ((n - shift) % k == 0) {
                count++;
            }
            k++;
        }
        
        return count;
    }
}