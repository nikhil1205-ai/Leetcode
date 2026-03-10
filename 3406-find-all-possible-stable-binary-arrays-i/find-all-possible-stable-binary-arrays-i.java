class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static record Node(int t, int r, int c){};
    public int numberOfStableArrays(int zero, int one, int limit) {
        int out = limit + 1;
        var dp = new Node[zero + 1][one + 1];
        dp[0][0] = new Node(0, 0, 0);
        for (int i = 1; i <= one; ++i) dp[0][i] = i <= limit ? new Node(1, 1, 0) : new Node(0, 0, 0);
        for (int i = 1; i <= zero; ++i) dp[i][0] = i <= limit ? new Node(1, 0, 1) : new Node(0, 0, 0);
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                int r = dp[i][j - 1].t, c = dp[i - 1][j].t;
                if (i > limit) c = (c + MOD - dp[i - out][j].r) % MOD; // one + consecutive zeros 
                if (j > limit) r = (r + MOD - dp[i][j - out].c) % MOD; // zero + consecutive zeros
                int t = (r + c) % MOD;
                dp[i][j] = new Node(t, r, c);
            }        
        }
        return dp[zero][one].t;
    }
}