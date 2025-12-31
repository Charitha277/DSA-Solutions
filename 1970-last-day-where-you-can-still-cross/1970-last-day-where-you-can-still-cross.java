class Solution {
    int[] d = {0, 1, 0, -1, 0};

    public int latestDayToCross(int r, int c, int[][] cells) {
        int l = 0, h = cells.length - 1, ans = 0;

        while (l <= h) {
            int m = (l + h) / 2;
            if (ok(r, c, cells, m)) {
                ans = m + 1;
                l = m + 1;
            } else h = m - 1;
        }
        return ans;
    }

    boolean ok(int r, int c, int[][] cells, int dday) {
        boolean[][] w = new boolean[r][c];
        for (int i = 0; i <= dday; i++)
            w[cells[i][0] - 1][cells[i][1] - 1] = true;

        Queue<int[]> q = new LinkedList<>();
        for (int j = 0; j < c; j++)
            if (!w[0][j]) q.add(new int[]{0, j});

        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (x[0] == r - 1) return true;
            for (int k = 0; k < 4; k++) {
                int nr = x[0] + d[k], nc = x[1] + d[k + 1];
                if (nr >= 0 && nc >= 0 && nr < r && nc < c && !w[nr][nc]) {
                    w[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
