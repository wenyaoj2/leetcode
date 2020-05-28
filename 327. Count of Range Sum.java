class CountRangeSum {
    int count;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        count = 0;
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = (long)sum[i-1] + nums[i-1];
        }
        helper(sum, 0, sum.length - 1, lower, upper);
        return count;
    }
    
    public void helper(long[] sum, int start, int end, int lower, int upper) {
        if(start >= end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        helper(sum, start, mid, lower, upper);
        helper(sum, mid+1, end, lower, upper);
        int j = mid + 1, k = mid + 1, l = mid + 1;
        long[] cache = new long[end - start + 1];
        int index = 0;
        for(int i = start; i <= mid; i++) {
            while(k <= end && sum[k] - sum[i] < lower) {
                k++;
            }
            while(l <= end && sum[l] - sum[i] <= upper) {
                l++;
            }
            while(j <= end && sum[j] < sum[i]) {
                cache[index++] = sum[j++];
            }
            count += l - k;
            cache[index++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, index);
    }
}