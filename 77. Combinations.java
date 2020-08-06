import java.util.*;

class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        helper(n, 1, k, new ArrayList(), res);
        return res;
    }
    private void helper(int n, int index, int k, List<Integer> cur, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList(cur));
        }
        for(int i = index; i <= n; i++) {
            cur.add(i);
            helper(n, i + 1, k - 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}