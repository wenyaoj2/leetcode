import java.util.*;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] seen = new int[candidates.length];
        List<List<Integer>> res = new ArrayList();
        dfs(candidates, target, 0, new ArrayList(), res, seen);
        return res;
    }
    private void dfs(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> res, int[] seen) {
        if(target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(target < 0) {
                return;
            }
            if(i != 0 && candidates[i] == candidates[i - 1] && seen[i - 1] == 0) {
                continue;
            }
            seen[i] = 1;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, cur, res, seen);
            cur.remove(cur.size() - 1);
            seen[i] = 0;
        }
    }
}