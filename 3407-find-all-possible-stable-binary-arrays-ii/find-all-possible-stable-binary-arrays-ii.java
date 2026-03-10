class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        // dp[i][j][0] = number of stable arrays with i zeros, j ones, ending in 0
        // dp[i][j][1] = number of stable arrays with i zeros, j ones, ending in 1
        int[][][] dp = new int[zero + 1][one + 1][2];

        // Base cases: arrays with only zeros or only ones (up to the limit)
        for (int i = 0; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 0; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // Transition for ending in 0
                long val0 = (long) dp[i - 1][j][0] + dp[i - 1][j][1];
                if (i > limit) {
                    // Subtract cases that would result in limit + 1 consecutive zeros
                    val0 -= dp[i - limit - 1][j][1];
                }
                dp[i][j][0] = (int) ((val0 + MOD) % MOD);

                // Transition for ending in 1
                long val1 = (long) dp[i][j - 1][0] + dp[i][j - 1][1];
                if (j > limit) {
                    // Subtract cases that would result in limit + 1 consecutive ones
                    val1 -= dp[i][j - limit - 1][0];
                }
                dp[i][j][1] = (int) ((val1 + MOD) % MOD);
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}