import java.util.*;

class SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap();
        hash.put(0, new ArrayList());
        hash.get(0).add(-1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hash.containsKey(sum - k)){
                res += hash.get(sum - k).size();
            }
            if(!hash.containsKey(sum)){
                hash.put(sum, new ArrayList());
            }
            hash.get(sum).add(i);
        }
        return res;
    }
}