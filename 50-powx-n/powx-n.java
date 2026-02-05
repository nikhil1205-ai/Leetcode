class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        long exp=n;
        if(n<0){
            x=1/x;
            exp=-exp;
        }
        double result=1.0;
        while(exp>0){
            if(exp%2!=0) result*=x;
            x*=x;
            exp=exp/2;
        }
        return result;
        
    }
}