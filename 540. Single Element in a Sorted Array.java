class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid]) {
                return nums[mid];
            }
            if((mid - start) % 2 == 0) {
                if(nums[mid + 1] == nums[mid]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
            else {
                if(nums[mid + 1] == nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }
}