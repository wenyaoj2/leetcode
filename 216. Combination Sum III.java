import java.util.*;

class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        helper(1, k, n, new ArrayList(), res);
        return res;
    }
    private void helper(int num, int k, int n, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == k) {
            if(n == 0)
                res.add(new ArrayList(cur));
            return;
        }
        for(int i = num; i <= 9; i++) {
            if(n < i) {
                return;
            }
            cur.add(i);
            helper(i + 1, k, n - i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}