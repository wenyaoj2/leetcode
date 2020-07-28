import java.util.*;

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, int[]> hash = new HashMap();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(!hash.containsKey(c)) {
                hash.put(c, new int[]{i, i});
            }
            else {
                hash.get(c)[1] = i;
            }
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comparator);
        for(char c : hash.keySet()) {
            pq.offer(hash.get(c));
        }
        List<Integer> res = new ArrayList();
        int[] cur = pq.poll();
        int start = cur[0];
        int end = cur[1];
        while(!pq.isEmpty()) {
            cur = pq.poll();
            if(cur[0] > end) {
                res.add(end - start + 1);
                start = cur[0];
                end = cur[1];
            }
            else {
                end = Math.max(cur[1], end);
            }
        }
        res.add(end - start + 1);
        return res;
    }
}