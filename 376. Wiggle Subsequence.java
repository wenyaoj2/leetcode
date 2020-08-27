class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < 2; j++) {
                dp[i][j] = 1;
            }
        }
        dp[0][1] = 1;
        if(nums[1] > nums[0]) {
            dp[1][1] = 2;
        }
        if(nums[1] < nums[0]) {
            dp[1][0] = 2;
        }
        int result = 1;
        for(int i = 2; i < nums.length; i++) {
            for(int j = 1; j < i; j++) {
                if(nums[i] == nums[j]) {
                    continue;
                }
                else if(nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                else {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        return result;
    }
}