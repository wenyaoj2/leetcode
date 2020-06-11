class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int cur = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > prev) {           
                cur++;             
            }
            else {
                cur = 1;
            }
            prev = nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}