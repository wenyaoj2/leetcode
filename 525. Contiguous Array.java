import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> hash = new HashMap();
        hash.put(0, -1);
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hash.containsKey(sum)) {
                max = Math.max(max, i - hash.get(sum));
            } 
            else {
                hash.put(sum, i);
            }
        }
        return max;
    }
}