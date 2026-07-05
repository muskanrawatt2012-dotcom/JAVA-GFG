class Solution {
    public int maxCharGap(String s) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }
        
        int maxGap = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            if (firstIndex[charIdx] == -1) {
                firstIndex[charIdx] = i;
            } else {
                int currentGap = i - firstIndex[charIdx] - 1;
                if (currentGap > maxGap) {
                    maxGap = currentGap;
                }
            }
        }
        
        return maxGap;
    }
}