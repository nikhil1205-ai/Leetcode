class Solution {
    void indegree(ArrayList<ArrayList<Integer>> adj,int indeg[]){
       for(int i=0;i<adj.size();i++){
         for(int v:adj.get(i)){
            indeg[v]++;
         }
       }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>()); 
        for(int i=0;i<prerequisites.length;i++){
            int edge[]=prerequisites[i];
            adj.get(edge[1]).add(edge[0]);
        }
         
        int indeg[] = new int[adj.size()];
        indegree(adj,indeg); 
        Queue<Integer> que=new LinkedList<>();
        for(int k=0;k<indeg.length;k++){
           if(indeg[k]==0) que.add(k);
        } 
        ArrayList<Integer> ans=new ArrayList<>();
        while(!que.isEmpty()){
            int curr=que.remove();
            ans.add(curr);
            for(int v:adj.get(curr)){
                indeg[v]--;
                if(indeg[v]==0) que.add(v);
            }
        }
        if (ans.size() != numCourses) return new int[0];
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
 
    }
}