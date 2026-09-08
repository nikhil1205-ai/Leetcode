class Solution {

    static boolean isvalid(List<String> temp, int row,int col,int n){
        for(int i=row-1;i>=0;i--){
            if(temp.get(i).charAt(col)=='Q') return false;
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(temp.get(i).charAt(j)=='Q') return false;
        }

        for(int i=row-1,j=col+1; i>=0 && j<n; i--,j++){
            if(temp.get(i).charAt(j)=='Q') return false;
        }

        return true;
    }
    static void nQueens(List<List<String>> arr,List<String> temp, int row,int n){
        if(row==n){
            arr.add(new ArrayList<>(temp));
            return;
        }

        for(int j=0;j<n;j++){
            if(isvalid(temp,row,j,n)){
                String str=temp.get(row);
                str=str.substring(0,j)+'Q'+str.substring(j+1);
                temp.set(row,str);
                nQueens(arr,temp,row+1,n);
                str=temp.get(row);
                str=str.substring(0,j)+'.'+str.substring(j+1);
                temp.set(row,str);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> arr = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(n==1) {
            temp.add("Q");
            arr.add(temp);
            return arr;
        }
        for(int i = 0; i < n; i++){
            temp.add(".".repeat(n));
        }
        
        nQueens(arr,temp,0,n);
        return arr;
    }
}