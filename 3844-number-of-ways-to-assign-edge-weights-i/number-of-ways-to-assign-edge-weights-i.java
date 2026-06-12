class Solution {
    static final int MOD = 1_000_000_007;

    long dfs(int node, int parent, HashMap<Integer, ArrayList<Integer>> tree) {
        long max = 0;

        for (int child : tree.get(node)) {
            if (child != parent) {
                max = Math.max(max, 1 + dfs(child, node, tree));
            }
        }

        return max;
    }

    long modPow(long a, long b) {
        long ans = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
    long depth(int[][] edges){
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
        for(int[] v: edges){
            tree.putIfAbsent(v[0], new ArrayList<>());
            tree.putIfAbsent(v[1], new ArrayList<>());
            tree.get(v[0]).add(v[1]);
            tree.get(v[1]).add(v[0]);
        }
        long max=dfs(1,-1,tree);
        return max;
    }
    public int assignEdgeWeights(int[][] edges) {
        long dep = depth(edges);
        return (int) modPow(2,dep-1);
    }
}