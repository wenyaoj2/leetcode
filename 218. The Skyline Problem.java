import java.util.*;

class GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        };
        List<int[]> heights = new ArrayList();
        for(int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, comparator);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> 
(b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] height : heights) {
            int a = Math.abs(height[1]);
            if(height[1] < 0) {
                pq.offer(a);
                if(prev < pq.peek()) {
                    List<Integer> cur = new ArrayList();
                    cur.add(height[0]);
                    cur.add(a);
                    ans.add(cur);
                    prev = pq.peek();
                }
            }
            else {
                pq.remove(a);
                if(prev > pq.peek()) {
                    List<Integer> cur = new ArrayList();
                    cur.add(height[0]);
                    cur.add(pq.peek());
                    ans.add(cur);
                    prev = pq.peek();
                }
            }
            
        }
        return ans;
    }
}