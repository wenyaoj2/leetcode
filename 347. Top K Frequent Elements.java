import java.util.*;

class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : hash.keySet()) {
            int num = hash.get(key);
            if(buckets[num] == null) {
                buckets[num] = new ArrayList();
            }
            buckets[num].add(key);
        }
        int[] res = new int[k];
        k = k - 1;
        for(int i = buckets.length - 1; i >= 0 && k >= 0; i--) {
            if(buckets[i] != null) {
                for(int n : buckets[i]) {
                    res[k--] = n;
                }
            }
        }
        return res;
    }
}