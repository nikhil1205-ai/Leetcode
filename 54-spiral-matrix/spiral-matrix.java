class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<Integer>();
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0,j=m-1,r=n-1,s=0;
        while(l <= r && s <= j){
            for(int i=s;i<=j;i++){
                arr.add(matrix[l][i]);
                
            }
            l++;
            for(int i=l;i<=r;i++){
                arr.add(matrix[i][j]);
                
            }
            j--;
            if (l <= r){
                for(int i=j;i>=s;i--){
                    arr.add(matrix[r][i]);
                    
                }
            }
            r--;
            if (s <= j){
                for(int i=r;i>=l;i--){
                    arr.add(matrix[i][s]); 
                }
            }
            s++;

        }

        return arr;
        
    }
}