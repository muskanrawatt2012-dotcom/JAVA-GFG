import java.util.Arrays;

class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        
        // Track the last occurrence of each character from 'a' to 'z'
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        for (int i = 0; i < n; i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        
        // minStartForChar[c] stores the minimum starting index ('a') 
        // that can reach character c
        int[] minStartForChar = new int[26];
        Arrays.fill(minStartForChar, Integer.MAX_VALUE);
        
        int maxDiff = -1;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int currentMinStart = Integer.MAX_VALUE;
            
            if (c == 0) {
                // If the character is 'a', it can be a starting index itself
                currentMinStart = i;
            } else {
                // Otherwise, it inherits the minimum start from the previous character 'c - 1'
                currentMinStart = minStartForChar[c - 1];
            }
            
            // If this position is reachable from a valid 'a'
            if (currentMinStart != Integer.MAX_VALUE) {
                // Update the minimum starting index capable of reaching character c
                minStartForChar[c] = Math.min(minStartForChar[c], currentMinStart);
                
                // Check if no further jump is possible from index i
                // (i.e., the next character in the alphabet does not appear after index i)
                boolean isEndIndex = (c == 25) || (lastPos[c + 1] < i);
                
                if (isEndIndex) {
                    maxDiff = Math.max(maxDiff, i - currentMinStart);
                }
            }
        }
        
        return maxDiff;
    }
}