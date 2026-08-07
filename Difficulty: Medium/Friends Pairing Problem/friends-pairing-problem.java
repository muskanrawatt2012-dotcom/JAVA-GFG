class Solution {
    public int countFriendsPairings(int n) {
        if (n <= 2) return n;
        
        long a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = b + (i - 1) * a;
            a = b;
            b = c;
        }
        return (int) b;
    }
}
