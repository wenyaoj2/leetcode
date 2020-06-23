class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum + 1];
        sum = sum / 2;
        dp[0] = true;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            for(int j = curSum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}