class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> hs= new HashMap<>();
        int a=0,b=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                hs.put(grid[i][j],hs.getOrDefault(grid[i][j],0)+1);
            }
        }
        for(int i=1;i<=grid.length*grid.length;i++){
            if(!hs.containsKey(i)) b=i;
            else if(hs.get(i)==2) a=i;
        }
        int arr[]=new int[2];
        arr[0]=a; arr[1]=b;
        return arr;
    }
}