class ReversePairs {
    int res = 0;
    public int reversePairs(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return res;
    }
    public void helper(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        helper(nums, start, mid);
        helper(nums, mid + 1, end);
        mergeSort(nums, start, end);
    }
    public void mergeSort(int[] nums, int start, int end) {
        int mid = (end - start) / 2 + start;
        int[] temp = new int[end - start + 1];
        // int i = start;
        int j = mid + 1, k = mid + 1;
        int index = 0;
        for(int i = start; i <= mid; i++) {
            while(j <= end && nums[j] < nums[i]) {
                temp[index++] = nums[j++];
            }
            while(k <= end &&  (long) 2 * nums[k] < (long) nums[i]) {
                k++;
            }
            temp[index++]  = nums[i];
            res += k - mid - 1;
        }
        System.arraycopy(temp, 0, nums, start, index);
    }
}