class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=0;
        while( row<matrix.length &&  matrix[row][col]<=target){
            if(matrix[row][col]==target) return true;
            row++;
        }
        row--;
        while( row>-1 && col<matrix[row].length &&  matrix[row][col]<=target  ){
            if(matrix[row][col]==target) return true;
            col++;
        }
        

        return false;
    }
}