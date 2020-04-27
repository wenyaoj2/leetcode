class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, 1) >= 0;
    }
    
    public int helper(int[] nums, int start, int end, int player){
        if(start == end){
            return nums[start] * player;
        }
        
        int a = nums[start] * player + helper(nums, start+1, end, -player);
        int b = nums[end] * player + helper(nums, start, end-1, -player);
        if(player > 0){
            return Math.max(a, b);
        }
        else{
            return Math.min(a, b);
        }
    }
}