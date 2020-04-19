class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                flag = true;
            }
            if(nums[i] >= n+1 || nums[i] <= 0){
                nums[i] = 1;
            }
        }
        if(!flag){
            return 1;
        }
        
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(nums[a - 1] < 0){
                continue;
            }
            nums[a - 1] = -nums[a - 1];
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}