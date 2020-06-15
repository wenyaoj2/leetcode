import java.util.*;

class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        if(nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> hash = new HashMap();
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        if(k == 0) {
            for(int i = 0; i < sums.length - 2; i++) {
                if(sums[i] == sums[i + 1] && sums[i + 1] == sums[i + 2]) {
                    return true;
                }
            }
            return false;
        }
        hash.put(0, 0);
        for(int i = 1; i < sums.length; i++) {
            int remainder = sums[i] % k;
            if(remainder == 0) {
                if(i != 1){
                    return true;
                }
            }
            if(hash.containsKey(remainder)) {
                if(i - hash.get(remainder) > 1) {
                    return true;
                }
            }
            if(!hash.containsKey(remainder)) {
                hash.put(remainder, i);
            }
        }
        return false;
    }
}