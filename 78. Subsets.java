import java.util.*;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(int[]  nums, int index, ArrayList<Integer> cur, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new  ArrayList(cur));
            return;
        }
        cur.add(nums[index]);
        helper(nums, index + 1, cur, res);
        cur.remove(cur.size() - 1);
        helper(nums, index + 1, cur, res);
    }
}