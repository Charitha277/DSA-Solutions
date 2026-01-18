class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // check square size from big to small
        for (int size = Math.min(rows, cols); size >= 2; size--) {
            for (int i = 0; i + size <= rows; i++) {
                for (int j = 0; j + size <= cols; j++) {
                    if (check(grid, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return 1; // 1x1 is always magic
    }

    boolean check(int[][] g, int r, int c, int size) {

        int sum = 0;
        for (int j = 0; j < size; j++) {
            sum += g[r][c + j]; // first row sum
        }

        // rows
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += g[r + i][c + j];
            }
            if (rowSum != sum) return false;
        }

        // columns
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += g[r + i][c + j];
            }
            if (colSum != sum) return false;
        }

        // main diagonal
        int d1 = 0;
        for (int i = 0; i < size; i++) {
            d1 += g[r + i][c + i];
        }
        if (d1 != sum) return false;

        // other diagonal
        int d2 = 0;
        for (int i = 0; i < size; i++) {
            d2 += g[r + i][c + size - 1 - i];
        }
        if (d2 != sum) return false;

        return true;
    }
}
