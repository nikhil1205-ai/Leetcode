class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int p = matrix.length, q = matrix[0].length;
        for (int i = 1; i < p; ++i) {
            for (int j = 0; j < q; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = q - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}