import java.util.*;

class LargestDivisibleSubset {
    List<Integer> res = new ArrayList();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) {
            return new ArrayList();
        }
        HashMap<Integer, List<Integer>> hash = new HashMap();
        hash.put(nums[0], new ArrayList());
        hash.get(nums[0]).add(nums[0]);
        for(int i = 0; i < nums.length; i++) {
            List<Integer> cur = helper(nums, i, hash);
            if(res.size() < cur.size()) {
                res = cur;
            }
        }
        List<Integer> temp = hash.get(1);
        
        return res;
    }
    public List<Integer> helper(int[] nums, int index, HashMap<Integer, List<Integer>> hash) {
        List<Integer> cur = new ArrayList();
        if(hash.containsKey(nums[index])) {
            return hash.get(nums[index]);
        }
        for(int i = index - 1; i >= 0; i--) {
            if(nums[index] % nums[i] == 0) {
                List<Integer> curList = helper(nums, i, hash);
                if(curList.size() > cur.size()) {
                    cur = new ArrayList(curList);
                }
            }
        }
        cur.add(nums[index]);
        hash.put(nums[index], new ArrayList(cur));
        return hash.get(nums[index]);
    }
}