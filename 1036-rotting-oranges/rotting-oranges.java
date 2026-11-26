class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]==2) que.add(new int[]{i,j,0});
            }
        }

        boolean[][] visit=new boolean[n][m];
        int ans=0;
        while(!que.isEmpty()){
               int[] curr=que.remove();
               int i=curr[0],j=curr[1],time=curr[2];
               ans=Math.max(ans,time);

               if(j+1<m && !visit[i][j+1] && grid[i][j+1]==1){
                  que.add(new int[]{i,j+1,time+1});
                  visit[i][j+1]=true;
               } 
               if(j-1>=0 && !visit[i][j-1] && grid[i][j-1]==1){
                   que.add(new int[]{i,j-1,time+1});
                   visit[i][j-1]=true;
               }
               if(i+1<n && !visit[i+1][j] && grid[i+1][j]==1){
                 que.add(new int[]{i+1,j,time+1});
                 visit[i+1][j]=true;
               }
               if(i-1>=0 && !visit[i-1][j] && grid[i-1][j]==1){
                  que.add(new int[]{i-1,j,time+1});
                  visit[i-1][j]=true;
               } 
           
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]==1 && !visit[i][j]) return -1;
            }
        }

        return ans;
    }
}