class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int n = helper(nums, start, end);
            if(n == target) {
                return nums[n];
            }
            else if(n < target) {
                start = n + 1;
            }
            else {
                end = n - 1;
            }
        }
        return -1;
    }
    public int helper(int[] nums, int start, int end) {
        if(start == end) {
            return start;
        }
        int pivot = nums[start];
        int cache = start;
        while(start <= end) {
            while(start <= end && nums[start] <= pivot) {
                start++;
            }
            while(start <= end && nums[end] > pivot) {
                end--;
            }
            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        nums[cache] = nums[end];
        nums[end] = pivot;
        return end;
    }
}