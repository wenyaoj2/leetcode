class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int[] seen = new int[nums.length];
        dfs(new ArrayList<Integer>(), ans, nums, seen);
        return ans;
    }
    
    public void dfs(List<Integer> list, List<List<Integer>> ans, int[] nums, int[] seen){
        if(list.size() == nums.length){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(seen[i] == 1){
                continue;
            }
            seen[i] = 1;
            list.add(nums[i]);
            dfs(list, ans, nums, seen);
            list.remove(list.size() - 1);
            seen[i] = 0;
        }
    }
}