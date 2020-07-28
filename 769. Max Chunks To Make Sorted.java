import java.util.*;

class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            hash.put(arr[i], i);
        }
        List<int[]> list = new ArrayList();
        for(int k : hash.keySet()) {
            int[] temp = new int[2];
            temp[0] = Math.min(k, hash.get(k));
            temp[1] = Math.max(k, hash.get(k));
            list.add(temp);
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        Collections.sort(list, comparator);
        int[] cur = list.get(0);
        int start = cur[0];
        int end = cur[1];
        int res = 1;
        for(int i = 1; i < list.size(); i++) {
            cur = list.get(i);
            if(cur[0] > end) {
                res++;
                start = cur[0];
                end = cur[1];
            }
            else {
                end = Math.max(end, cur[1]);
            }
        }
        return res;
    }
}