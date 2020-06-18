class NextPermutation {
    public void nextPermutation(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] >= nums[i + 1]) {
                continue;
            }
            int index = i;
            start = i + 1;
            while(start < nums.length) {
                if(nums[start] <= nums[index]) {
                    break;
                }
                start++;
            }
            int temp = nums[index];
            nums[index] = nums[start - 1];
            nums[start - 1] = temp;
            start = index + 1;
            break;
        }
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}