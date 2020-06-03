import java.util.*;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue(comparator);
        for(int i = 0; i < costs.length; i++) {
            pq.offer(new int[]{costs[i][0] - costs[i][1], i});
        }
        for(int i = 0; i < costs.length / 2; i++) {
            int index = pq.poll()[1];
            res += costs[index][0];
        }
        while(!pq.isEmpty()) {
            int index = pq.poll()[1];
            res += costs[index][1];
        }
        return res;
    }
}