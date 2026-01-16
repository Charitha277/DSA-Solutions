import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Add boundaries
        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
        int[] v = Arrays.copyOf(vFences, vFences.length + 2);

        h[h.length - 2] = 1;
        h[h.length - 1] = m;
        v[v.length - 2] = 1;
        v[v.length - 1] = n;

        Arrays.sort(h);
        Arrays.sort(v);

        // Store all possible distances
        Set<Integer> hDiff = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hDiff.add(h[j] - h[i]);
            }
        }

        int maxSide = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int diff = v[j] - v[i];
                if (hDiff.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }

        if (maxSide == 0) return -1;

        long mod = 1_000_000_007;
        return (int)((maxSide * 1L * maxSide) % mod);
    }
}
