import java.util.*;

class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        HashMap<String, Integer> hash = new HashMap();
        return helper(nums, 0, 0, S, hash);
    }
    public int helper(int[] nums, int cur, int index, int S, HashMap<String, Integer> hash) {
        int count = 0;
        if(index == nums.length) {
            if(cur == S) {
                return 1;
            }
            return 0;
        }
        String s = cur + " " + index;
        if(hash.containsKey(s)) {
            return hash.get(s);
        }
        count = helper(nums, cur + nums[index], index + 1, S, hash) + helper(nums, cur - nums[index], index + 1, S, hash);
        hash.put(s, count);
        return count;
    }
}