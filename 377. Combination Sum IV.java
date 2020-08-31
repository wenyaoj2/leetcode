class CombinationSum4 {
    HashMap<Integer, Integer> hash = new HashMap();
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target);
    }
    private int helper(int[] nums, int target) {
        if(target == 0) {
            return 1;
        }
        int result = 0;
        if(hash.containsKey(target)) {
            return hash.get(target);
        }
        for(int i = 0; i < nums.length; i++) {
            if(target < nums[i]) {
                break;
            }
            result += helper(nums, target - nums[i]);
        }
        hash.put(target, result);
        return result;
    }
}