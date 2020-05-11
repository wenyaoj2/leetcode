class MaxProduct {
    public int maxProduct(int[] nums) {
        int ans = nums[0]; 
        int maxTotal = nums[0];
        int minTotal = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int curMax = nums[i] * maxTotal;
            int curMin = nums[i] * minTotal;
            if(nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
                
            }
            maxTotal = Math.max(curMax, nums[i]);
            minTotal = Math.min(curMin, nums[i]);
            ans = Math.max(maxTotal, ans);
        }
        return ans;
    }
}