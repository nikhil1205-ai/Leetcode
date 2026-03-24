class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int prefix=1;
        int suffix=1;

        int[][] p = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                p[i][j]=prefix;
                prefix = (prefix*(grid[i][j]%12345))%12345;
            }
        }
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                p[i][j]=(p[i][j]*suffix)%12345;
                suffix = (suffix*(grid[i][j]%12345))%12345;
            }
        }
        return p;
    }
}