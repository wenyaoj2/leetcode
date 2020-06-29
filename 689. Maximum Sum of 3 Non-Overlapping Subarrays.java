class MaxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int[] left = new int[nums.length];
        left[k - 1] = 0;
        int sum = 0;
        for(int i = k; i < nums.length; i++) {
            sum = sums[i + 1] - sums[i - k + 1];
            // System.out.println(left[i - 1] + k + " " + i);
            int leftMax = sums[left[i - 1] + k] - sums[left[i - 1]];
            left[i] = (sum > leftMax) ? i - k + 1 : left[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - k] = nums.length - k;
        sum = 0;
        for(int i = nums.length - k - 1; i >= 0; i--) {
            sum = sums[i + k] - sums[i];
            int rightMax = sums[right[i + 1] + k] - sums[right[i + 1]];
            right[i] = (sum >= rightMax) ? i : right[i + 1];
        }
        int[] res = new int[3];
        int max = 0;
        for(int i = k; i <= nums.length - 2 * k; i++) {
            sum = sums[i + k] - sums[i] + sums[left[i - 1] + k] - sums[left[i - 1]] + sums[right[i + k] + k] - sums[right[i + k]];
            if(sum > max) {
                max = sum;
                res[0] = left[i - 1];
                res[1] = i;
                res[2] = right[i + k];
            }
        }
        return res;
    }
}