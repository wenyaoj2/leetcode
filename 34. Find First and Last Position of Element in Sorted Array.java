class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] != target && nums[end] != target) {
            return new int[]{-1, -1};
        }
        int num1 = 0;
        if(nums[start] == target) {
            num1 = start;
        }
        else {
            num1 = end;
            start = end;
        }
        end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[end] == target) {
            return new int[]{num1, end};
        }
        return new int[]{num1, start};
    }
}