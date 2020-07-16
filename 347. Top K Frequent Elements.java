import java.util.HashMap;

class TopKFrequent {
    class Pair {
        int val;
        int times;
        public Pair(int val, int times) {
            this.val = val;
            this.times = times;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num,  0) + 1);
        }
        Pair[] pairs = new Pair[hash.size()];
        int index = 0;
        for(int key : hash.keySet()) {
            Pair p = new Pair(key, hash.get(key));
            pairs[index++] = p;
        }
        int[] res = new int[k];
        int target = pairs.length - k;
        int start = 0, end = pairs.length - 1;
        while(start <= end) {
            int n = helper(pairs, start, end);
            if(n == target) {
                break;
            }
            else if(n < target) {
                start = n + 1;
            }
            else {
                end = n - 1;
            }
        }
        for(int i = target; i < pairs.length; i++) {
            res[i - target] = pairs[i].val;
        }
        return res;
    }
    public int helper(Pair[] pairs, int start, int end) {
        int pivot = pairs[start].times;
        int index = start;
        Pair obj = pairs[start];
        while(start <= end) {
            while(start <= end && pairs[start].times <= pivot) {
                start++;
            }
            while(start <= end && pairs[end].times > pivot) {
                end--;
            }
            if(start <= end) {
                Pair p = pairs[start];
                pairs[start++] = pairs[end];
                pairs[end--] = p;
            }
        }
        pairs[index] = pairs[end];
        pairs[end] = obj;
        return end;
    }
}