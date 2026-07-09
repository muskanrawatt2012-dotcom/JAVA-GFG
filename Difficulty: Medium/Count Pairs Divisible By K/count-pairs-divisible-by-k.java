class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            freq[num % k]++;
        }
        
        int count = 0;
        
        count += (freq[0] * (freq[0] - 1)) / 2;
        
        for (int i = 1; i <= (k - 1) / 2; i++) {
            count += freq[i] * freq[k - i];
        }
        
        if (k % 2 == 0) {
            count += (freq[k / 2] * (freq[k / 2] - 1)) / 2;
        }
        
        return count;
    }
}