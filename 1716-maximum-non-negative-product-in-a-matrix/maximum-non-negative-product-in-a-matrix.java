class Solution {
    public int maxProductPath(int[][] grid) {
        long mod = (long) 1e9 +7;
        int m =grid.length;
        int n = grid[0].length;
        long mindp[][] = new long [m][n];
        long maxdp[][]= new long [m][n];
        maxdp[0][0] = mindp[0][0] = grid[0][0];
        for(int i =1;i<m;i++){
            mindp[i][0]=maxdp[i][0]= maxdp[i-1][0] * grid[i][0]; //top
        }
         for(int j =1;j<n;j++){
            mindp[0][j]=maxdp[0][j]= maxdp[0][j-1] * grid[0][j]; //left
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long val = grid[i][j];
                long a = maxdp[i-1][j]* val;
                long b = mindp[i-1][j]* val;
                long c = maxdp[i][j-1]* val;
                long d = mindp[i][j-1]* val;
              maxdp[i][j] = Math.max(Math.max(a,b),Math.max(c,d));
              mindp[i][j] = Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        long res = maxdp[m-1][n-1];
        if(res<0){
            return -1;
        }
        return (int) (res % mod);
    }
}