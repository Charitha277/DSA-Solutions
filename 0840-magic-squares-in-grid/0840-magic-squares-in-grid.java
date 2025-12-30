class Solution {
    public int numMagicSquaresInside(int[][] g) {
        int res = 0;
        for (int i = 0; i + 2 < g.length; i++)
            for (int j = 0; j + 2 < g[0].length; j++)
                if (magic(g, i, j)) res++;
        return res;
    }

    boolean magic(int[][] g, int r, int c) {
        if (g[r+1][c+1] != 5) return false; // center must be 5

        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int v = g[r+i][c+j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }

        return g[r][c] + g[r][c+1] + g[r][c+2] == 15 &&
               g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] == 15 &&
               g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] == 15 &&
               g[r][c] + g[r+1][c] + g[r+2][c] == 15 &&
               g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] == 15 &&
               g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] == 15 &&
               g[r][c] + g[r+1][c+1] + g[r+2][c+2] == 15 &&
               g[r][c+2] + g[r+1][c+1] + g[r+2][c] == 15;
    }
}
