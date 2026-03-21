class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow = x;
        int endRow = startRow + k - 1;
        int startCol = y;
        int endCol = startCol + k - 1;

        // Break when startRow == endRow
        for(int i = startRow; i < endRow; i++) {
            for(int j = startCol; j <= endCol; j++) {
                
                // swap startRow and endRow elements
                int temp = grid[i][j];
                grid[i][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }

            // Decrease endRow after swapping the elements
            endRow--;
        }

        return grid;
    }
}