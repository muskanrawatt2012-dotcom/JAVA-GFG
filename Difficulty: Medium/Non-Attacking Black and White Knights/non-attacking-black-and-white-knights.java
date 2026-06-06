class Solution {
    public int numOfWays(int n, int m) {
        long total = 1L * n * m;
        
        long ways = total * (total - 1); 
        
        long attack = 0;
        
        if (n >= 2 && m >= 3) {
            attack += 1L * (n - 1) * (m - 2);
        }
        if (n >= 3 && m >= 2) {
            attack += 1L * (n - 2) * (m - 1);
        }
        
        ways -= 4L * attack;
        
        return (int) ways;
    }
}