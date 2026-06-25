class Solution {
    public boolean search(char[][] board,String word,int i,int j,int index){
        int m=board.length;
        int n=board[0].length;
        if(index==word.length()) return true;
        if(i<0 || i>=m || j<0 || j>=n) return false;
        if(board[i][j]!=word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found=search(board,word,i-1,j,index+1) ||
        search(board,word,i+1,j,index+1) ||
        search(board,word,i,j-1,index+1) ||
        search(board,word,i,j+1,index+1) ;
        board[i][j] = temp;
        return found;

    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int l=0;l<m;l++){
            for(int k=0;k<n;k++){
              if (board[l][k] == word.charAt(0)){
                if(search(board,word,l,k,0)){
                    return true;
                }
              }
            }
        }
        return false;

    }
}