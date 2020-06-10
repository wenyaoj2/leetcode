class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if(nums[end] < target) {
            return end + 1;
        }
        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] >= target) {
            return start;
        }
        return end;
    }
}