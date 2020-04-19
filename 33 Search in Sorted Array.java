class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[0]){
                if(target >= nums[0]){
                    if(nums[mid] < target){
                        start = mid;
                    }
                    else{
                        end = mid;
                    }
                }
                else{
                    start = mid;
                }
            }
            else{
                if(target >= nums[0]){
                    end = mid;
                }
                else{
                    if(nums[mid] < target){
                        start = mid;
                    }
                    else{
                        end = mid;
                    }
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}