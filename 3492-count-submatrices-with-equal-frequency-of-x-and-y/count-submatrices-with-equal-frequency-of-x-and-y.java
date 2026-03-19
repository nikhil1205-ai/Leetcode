class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans  = 0 ;

        int[][] prefixSum = new int[rows][cols];
        boolean[][] hasX = new boolean[rows][cols];

        // First cell
        prefixSum[0][0] = getValue(grid[0][0]);
        hasX[0][0] = (grid[0][0] == 'X');

        

        //First row
        for (int j = 1; j < cols; j++) {
            prefixSum[0][j] = prefixSum[0][j - 1] + getValue(grid[0][j]);
            hasX[0][j] = hasX[0][j - 1] || (grid[0][j] == 'X');

            if (hasX[0][j] && prefixSum[0][j]==0) ans++ ;
        }

        // Rest of grid
        for (int i = 1; i < rows; i++) {
            
            // First Column
            prefixSum[i][0] = prefixSum[i - 1][0] + getValue(grid[i][0]);
            hasX[i][0] = hasX[i - 1][0] || (grid[i][0] == 'X');

            if(hasX[i][0] && prefixSum[i][0]==0) ans++;

            // rest Of the Cells
            for (int j = 1; j < cols; j++) {

                int val = getValue(grid[i][j]);

                prefixSum[i][j] = val
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];

                hasX[i][j] = hasX[i - 1][j]
                        || hasX[i][j - 1]
                        || (grid[i][j] == 'X');

                if (hasX[i][j] && prefixSum[i][j]==0) ans++;
            }
        }

    

        return ans;
    }

    private int getValue(char ch) {
        if (ch == 'X') return 1;
        if (ch == 'Y') return -1;
        return 0;
    }
}