class Solution {
    public double myPow(double x, int n) {
        boolean exp=false;
        long N=n;
        if (N<0) {
            exp=true;
            N=-(N);
        }
        double ans=1;
        while(N>0){
            if((N&1)!=0) ans=ans*x;
            x=x*x;
            N>>=1;
        }

        if(exp) ans=1/ans;
        return ans;

    }
}