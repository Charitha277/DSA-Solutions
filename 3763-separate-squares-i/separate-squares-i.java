class Solution {
    public double separateSquares(int[][] squares) {

        double low = 0, high = 1e9;

        for (int i = 0; i < 60; i++) {   // binary search for precision
            double mid = (low + high) / 2;
            double below = 0, above = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                if (mid <= y) {
                    above += l * l;
                } else if (mid >= y + l) {
                    below += l * l;
                } else {
                    below += (mid - y) * l;
                    above += (y + l - mid) * l;
                }
            }

            if (below < above)
                low = mid;
            else
                high = mid;
        }

        return low;
    }
}
