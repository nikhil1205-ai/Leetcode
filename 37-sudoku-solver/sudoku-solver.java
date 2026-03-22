class Solution {
    public static boolean isSafe(char[][] board,int row,int col,char digit){
        for(int i=0;i<9;i++){
            if(board[row][i]==digit) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==digit) return false;
        }
        int Srow=(row/3)*3;
        int Scol=(col/3)*3;
        for(int i=Srow;i<Srow+3 ;i++){
          for(int j=Scol;j<Scol+3;j++){
               if(board[i][j]==digit) return false;
          }
        }
        return true;
    }

    public static boolean solver(char[][] board , int row ,int col){
        if(row==9 && col==0) return true;
        int nextRow=row , nextcol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextcol=0;
        }
        if(board[row][col]!='.'){
            return solver(board,nextRow,nextcol);
        }
        for(int digit=1;digit<=9;digit++){
          if(isSafe(board,row,col,(char)(digit+'0'))){
              board[row][col]=(char)(digit+'0');
              if(solver(board,nextRow,nextcol)){
                    return true;
              }
              board[row][col]='.';
          }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
}