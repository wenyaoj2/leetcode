import java.util.*;

class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int sum = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                if(nums[start] + nums[end] < sum || (start != i+1 && nums[start] == nums[start-1])) {
                    start++;
                }
                else if(nums[start] + nums[end] > sum || (end != nums.length - 1 && nums[end] == nums[end+1])) {
                    end--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                }
            }
        }
        return res;
    }
}