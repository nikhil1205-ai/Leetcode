class Solution {
    // public int count(int i,int j,int m,int n){
    //   if(i==m-1 && j==n-1){
    //     return 1;
    //   }else if(i==m || j==n){
    //      return 0;
    //   }
    //   int w1=count(i+1,j,m,n);
    //   int w2=count(i,j+1,m,n);
    //   return w1+w2;
    // }
    long fact(int N,int r){
        long res=1;
        for(int i=1;i<=r;i++) res=res*(N-r+i)/i;
        return res;
    }
    public int uniquePaths(int m, int n) {
        // return count(0,0,m,n);
        int  N=n+m-2;
        int r=Math.min(m-1,n-1);
        return (int)fact(N,r);
    }
}