import java.util.HashMap;

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hash = new HashMap();
        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(int k : hash.keySet()) {
            if(hash.get(k) == 1) {
                res[index++] = k;
            }
        }
        return res;
    }
}