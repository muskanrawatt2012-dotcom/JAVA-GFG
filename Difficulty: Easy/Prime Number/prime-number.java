class Solution {
    static boolean isPrime(int n) {
        // code here
        boolean k = true;
        if (n==1){
            return false;
        }
        for(int i=2;i <= Math.sqrt(n);i++){
            if(n%i==0){
                k = false;
            }
        }if(k==true){
        return true;
        }else{
            return false;
        }
    }
}