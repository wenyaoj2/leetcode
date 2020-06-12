import java.util.*;

class Sum3Closet {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                if(nums[start] + nums[end] == sum) {
                    return target;
                }
                else if(nums[start] + nums[end] < sum) {
                    if(min > sum - nums[start] - nums[end]) {
                        min = sum - nums[start] - nums[end];
                        res = target - min;
                    }
                    start++;
                }
                else {
                    if(min > nums[start] + nums[end] - sum) {
                        min = nums[start] + nums[end] - sum;
                        res = target + min;
                    }
                    end--;
                }
            }
        }
        return res;
    }
}