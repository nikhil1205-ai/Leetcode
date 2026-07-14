class Solution {
    public static boolean searchRow(int[][] matrix, int target , int row){
       int m=matrix[0].length-1;
       int start=0 , end=m;
       while(start<=end){
          int mid=(start+end)/2;
          if(target == matrix[row][mid]){
            return true;
          }
          else if(target < matrix[row][mid]){
            end=mid-1;
          }else{
            start=mid+1;
          }              
       }
       return false;   
    }

    public boolean searchMatrix(int[][] matrix, int target) {
       int n=matrix.length,m=matrix[0].length;
       int start=0 , end=n-1;
       while(start<=end){
          int mid=(start+end)/2;
          if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length-1]){
            return searchRow(matrix,target,mid);
          }
          else if(target < matrix[mid][0]){
            end=mid-1;
          }else{
            start=mid+1; 
          }              

       }

       return false;

    }
}




        // int row=0,col=0;
        // while( row<matrix.length &&  matrix[row][col]<=target){
        //     if(matrix[row][col]==target) return true;
        //     row++;
        // }
        // row--;
        // while( row>-1 && col<matrix[row].length &&  matrix[row][col]<=target  ){
        //     if(matrix[row][col]==target) return true;
        //     col++;
        // }
        // return false;