class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < nums.length && nums[left] == 0) {
            left++;
        }
        while(right >= 0 && nums[right] == 2) {
            right--;
        }
        int i = left;
        while(i <= right) {
            if(nums[i] == 1) {
                i++;
            }
            else if(nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            }
            else {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}