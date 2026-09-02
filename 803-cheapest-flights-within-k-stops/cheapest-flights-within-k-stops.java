class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:flights){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        int dist[] = new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        Queue<int[]> qu=new LinkedList<>();
        
        qu.add(new int[]{src,0,0});

        while(!qu.isEmpty()){
            int[] curr= qu.remove();
            if(curr[2]>k) break;
                for(int[] edge:adj.get(curr[0])){
                    if(dist[curr[0]]!=Integer.MAX_VALUE){
                        int wt=curr[1]+edge[1];
                        if(wt<dist[edge[0]] && curr[2]<=k){
                            dist[edge[0]]=wt;
                            qu.add(new int[]{edge[0],wt,curr[2]+1});
                        } 
                    }
                }
            

        }

        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];

        
    }
}