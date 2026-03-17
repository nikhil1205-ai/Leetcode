class Solution {
    public static boolean isSafe(char[][] arr,int row ,int j){
        for(int i=row-1;i>=0;i--){
            if(arr[i][j]=='Q') return false;
        }
        for(int i=row-1,k=j-1;i>=0 && k>=0;i--,k--){
            if(arr[i][k]=='Q') return false;
        }
        for(int i=row-1,k=j+1;i>=0 && k<arr.length;i--,k++){
            if(arr[i][k]=='Q') return false;
        }
        return true;
    }
    public static void  permutation(char[][] arr,List<List<String>> st,int row){
        if(row==arr.length){
           List<String> subst= new ArrayList<>();
           for(int i=0;i<arr.length;i++){
            String temp="";
            for(int j=0;j<arr.length;j++){
                temp+=arr[i][j];
            }
            subst.add(temp);
            temp="";
           }
           st.add(subst);
           return;
        }

        for(int j=0;j<arr.length;j++){
            if(isSafe(arr,row,j)){
                arr[row][j]='Q';
                permutation(arr,st,row+1);
                arr[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n]; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]='.';
            }
        }
        List<List<String>> st= new ArrayList();
        permutation(arr,st,0);
        return st;
        
    }
}