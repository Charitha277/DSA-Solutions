import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) free.offer(i);

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1], dur = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.offer((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                long[] e = busy.poll();
                long newEnd = e[0] + dur;
                int room = (int) e[1];
                count[room]++;
                busy.offer(new long[]{newEnd, room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }

        return ans;
    }
}
