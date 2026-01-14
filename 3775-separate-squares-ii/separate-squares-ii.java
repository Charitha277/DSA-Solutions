import java.util.*;

class Solution {

    static class Event {
        double y;
        int l, r, type;
        Event(double y, int l, int r, int type) {
            this.y = y;
            this.l = l;
            this.r = r;
            this.type = type;
        }
    }

    double[] xs;
    int[] cover;
    double[] length;

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();
        List<Double> xList = new ArrayList<>();

        for (int[] s : squares) {
            double x1 = s[0], x2 = s[0] + s[2];
            double y1 = s[1], y2 = s[1] + s[2];

            xList.add(x1);
            xList.add(x2);

            events.add(new Event(y1, 0, 0, +1));
            events.add(new Event(y2, 0, 0, -1));
        }

        xs = xList.stream().distinct().sorted().mapToDouble(Double::doubleValue).toArray();
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++) map.put(xs[i], i);

        int idx = 0;
        for (int[] s : squares) {
            int l = map.get((double) s[0]);
            int r = map.get((double) (s[0] + s[2])) - 1;

            events.get(idx).l = l;
            events.get(idx).r = r;
            idx++;
            events.get(idx).l = l;
            events.get(idx).r = r;
            idx++;
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        int n = xs.length;
        cover = new int[4 * n];
        length = new double[4 * n];

        double totalArea = 0;
        double prevY = events.get(0).y;

        // First pass: compute total union area
        for (Event e : events) {
            totalArea += length[1] * (e.y - prevY);
            update(1, 0, n - 2, e.l, e.r, e.type);
            prevY = e.y;
        }

        // Reset for second sweep
        Arrays.fill(cover, 0);
        Arrays.fill(length, 0);

        double half = totalArea / 2;
        double acc = 0;
        prevY = events.get(0).y;

        // Second pass: find y where area reaches half
        for (Event e : events) {
            double dy = e.y - prevY;
            double slice = length[1] * dy;

            if (acc + slice >= half) {
                return prevY + (half - acc) / length[1];
            }

            acc += slice;
            update(1, 0, n - 2, e.l, e.r, e.type);
            prevY = e.y;
        }

        return prevY;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql > r || qr < l || l > r) return;

        if (ql <= l && r <= qr) {
            cover[node] += val;
        } else {
            int m = (l + r) / 2;
            update(node * 2, l, m, ql, qr, val);
            update(node * 2 + 1, m + 1, r, ql, qr, val);
        }

        if (cover[node] > 0) {
            length[node] = xs[r + 1] - xs[l];
        } else if (l == r) {
            length[node] = 0;
        } else {
            length[node] = length[node * 2] + length[node * 2 + 1];
        }
    }
}
