import java.util.*;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        };
        Arrays.sort(intervals, comparator);
        int res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            int end = pq.peek();
            if(intervals[i][0] < end) {
                pq.offer(intervals[i][1]);
                res++;
            }
            else {
                pq.poll();
                pq.offer(intervals[i][1]);
            }
        }
        return res;
    }
}