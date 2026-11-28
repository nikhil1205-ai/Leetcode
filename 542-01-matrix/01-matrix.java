class Solution {
    public int[][] updateMatrix(int[][] mat) {
       Queue<int[]> que=new LinkedList<>();
       int n=mat.length, m=mat[0].length;
       for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            if(mat[i][j]==0) que.add(new int[]{i,j});
            else{
                mat[i][j]=-1;
            }
         }
       }

       int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

       while(!que.isEmpty()){
          int[] curr=que.remove();
          for(int[] d:dir){
            int nr=curr[0]+d[0],nc=curr[1]+d[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==-1){
                mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                que.add(new int[]{nr, nc});
            }
          }

       }


      return mat;


    }
}