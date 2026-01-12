class Solution {
    public boolean isPalindrome(int n) {
    int a =n;
    int rev=0;
    while(a>0){
        int lastdigit=a%10;
        rev=(rev*10)+lastdigit;
        a=a/10;
    }if(rev==n)
    return true;
    else
    return false;
        
    }
}