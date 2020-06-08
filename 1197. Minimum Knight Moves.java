import java.util.*;


class MinKnightMoves {
    HashMap<String, Integer> hash;
    public int minKnightMoves(int x, int y) {
        hash = new HashMap();
        x = Math.abs(x);
        y = Math.abs(y);
        // System.out.println(x + " " + y);
        return helper(x, y);
    }
    public int helper(int x, int y) {
        String s = x + " " + y;
        if(hash.containsKey(s)) {
            return hash.get(s);
        }
        if(x == 0 && y == 0) {
            return 0;
        }
        if(x + y == 2) {
            return 2;
        }
        int ans = Math.min(helper(Math.abs(x - 2), Math.abs(y - 1)), helper(Math.abs(x - 1), Math.abs(y - 2))) + 1;
        hash.put(s, ans);
        return ans;
    }
}