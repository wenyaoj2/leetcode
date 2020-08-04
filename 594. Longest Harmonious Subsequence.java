import java.util.HashMap;

class FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int num : hash.keySet()) {
            if(hash.containsKey(num - 1)) {
                res = Math.max(hash.get(num) + hash.get(num - 1), res);
            }
            if(hash.containsKey(num + 1)) {
                res = Math.max(hash.get(num) + hash.get(num + 1), res);
            }
            
        }
        return res;
    }
}