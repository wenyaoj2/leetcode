class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for(int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(curMax, max);
        }
        return max;
    }
}