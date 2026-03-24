class Solution {

    boolean cheack(int[][] grid,int i,int j,int k){
        int n=grid.length;

        if(k==n*n-1) return true;

        boolean w1=false,w2=false,w3=false,w4=false;
        boolean w5=false,w6=false,w7=false,w8=false;

        if(i-2 >=0 && j-1>=0 && grid[i-2][j-1]==k+1)
            w1=cheack(grid,i-2,j-1,k+1);

        if(i-2 >=0 && j+1<n && grid[i-2][j+1]==k+1)
            w2=cheack(grid,i-2,j+1,k+1);

        if(i+2 <n  && j-1 >= 0 && grid[i+2][j-1]==k+1)
            w3=cheack(grid,i+2,j-1,k+1);

        if(i+2 < n && j+1 < n && grid[i+2][j+1]==k+1)
            w4=cheack(grid,i+2,j+1,k+1);

        if(i-1 >=0 && j-2>=0 && grid[i-1][j-2]==k+1)
            w5=cheack(grid,i-1,j-2,k+1);

        if(i+1 < n  && j-2>=0 && grid[i+1][j-2]==k+1)
            w6=cheack(grid,i+1,j-2,k+1);

        if(i-1 >=0 && j+2<n && grid[i-1][j+2]==k+1)
            w7=cheack(grid,i-1,j+2,k+1);

        if(i+1 < n && j+2 < n && grid[i+1][j+2]==k+1)
            w8=cheack(grid,i+1,j+2,k+1);

        return w1 || w2 || w3 || w4 || w5 || w6 || w7 || w8;
    }

    public boolean checkValidGrid(int[][] grid) {
        return grid[0][0] == 0 && cheack(grid,0,0,0);
    }
}