class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int products = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            left[i] = left[i] * products;
            products = products * nums[i];
        }
        return left;
    }
}