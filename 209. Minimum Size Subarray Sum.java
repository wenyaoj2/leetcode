class SubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        while(right < sums.length) {
            if(sums[right] - sums[left] == s) {
                min = Math.min(right - left, min);
                right++;
            }
            else if(sums[right] - sums[left] > s) {
                min = Math.min(right - left, min);
                left++;
            }
            else {
                right++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}