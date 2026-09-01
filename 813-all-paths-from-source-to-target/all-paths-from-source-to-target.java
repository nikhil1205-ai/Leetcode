class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> helper= new ArrayList<>();
        dfs(0,graph.length-1,arr,graph ,helper);
        return arr;
    }

    public static void dfs(int src,int dest,List<List<Integer>> arr, int[][] graph,List<Integer> helper){
        helper.add(src);
        if(src==dest){
            arr.add(new ArrayList<>(helper));
        }else{
        for(int i:graph[src]){
            dfs(i,dest,arr,graph,helper); 
        }
        }
        helper.remove(helper.size()-1);
    }
}