import java.util.*;

class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comparator);
        for(int[] interval : intervals) {
            pq.offer(interval);
        }
        int[] cur = pq.poll();
        int start = cur[0];
        int end = cur[1];
        while(!pq.isEmpty()) {
            int[] next = pq.poll();
            if(next[0] > end) {
                list.add(new int[]{start, end});
                start = next[0];
                end = next[1];
            }
            else {
                end = Math.max(end, next[1]);  
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}