
class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean vis[] = new boolean[n];
        int minDist[] = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;

        int total = 0;

        for (int i = 0; i < n; i++) {

            // Find the unvisited point with minimum distance
            int u = -1;

            for (int j = 0; j < n; j++) {

                if (!vis[j] &&
                    (u == -1 || minDist[j] < minDist[u])) {

                    u = j;
                }
            }

            // Include this point in MST
            vis[u] = true;
            total += minDist[u];

            // Update distances of remaining points
            for (int v = 0; v < n; v++) {

                if (!vis[v]) {

                    int dist = Math.abs(points[u][0] - points[v][0])
                             + Math.abs(points[u][1] - points[v][1]);

                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }

        return total;
    }
}

