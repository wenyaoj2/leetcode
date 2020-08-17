class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                boolean flag1 = isNonDecreasing(nums);
                nums[i - 1] = temp;
                nums[i] = temp;
                boolean flag2 = isNonDecreasing(nums);
                return flag1 || flag2;
            }
        }
        return true;
    }
    private boolean isNonDecreasing(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}