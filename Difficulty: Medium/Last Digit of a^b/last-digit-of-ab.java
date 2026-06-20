class Solution {
    public int getLastDigit(String a, String b) {
        
        if (b.equals("0")) return 1;
        
        int lastDigit = a.charAt(a.length() - 1) - '0';
        
        int expMod = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod = (expMod * 10 + (b.charAt(i) - '0')) % 4;
        }
        
        if (expMod == 0) expMod = 4;
        
        int ans = 1;
        for (int i = 0; i < expMod; i++) {
            ans = (ans * lastDigit) % 10;
        }
        
        return ans;
    }
}