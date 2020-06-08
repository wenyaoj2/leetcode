import java.util.*;

class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        if(nums.length == 0) {
            res.add((upper > lower) ? lower + "->" + upper : "" + lower);
            return res;
        }
        if(nums[0] > lower) {
            res.add((nums[0] > lower + 1) ? lower + "->" + (nums[0] - 1) : "" + lower);
        }
        lower = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > lower + 1) {
                res.add((nums[i] > lower + 2) ? (lower + 1) + "->" + (nums[i] - 1) : "" + (lower + 1));
            }
            if(nums[i] == upper) {
                return res;
            }
            lower = nums[i];
        }
        if(lower < upper)
            res.add((upper > lower + 1) ? (lower + 1) + "->" + upper : "" + upper);
        return res;
    }
}