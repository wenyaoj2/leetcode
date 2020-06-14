import java.util.*;

import javafx.util.Pair;

class FindCheapestPrice {
    HashMap<Integer, List<int[]>> hash;
    HashMap<Pair<Integer, Integer>, Long> seen;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        hash = new HashMap();
        seen = new HashMap();
        for(int i = 0; i < n; i++) {
            hash.put(i, new ArrayList());
        }
        for(int[] flight : flights) {
            hash.get(flight[0]).add(new int[]{flight[1], flight[2]});
        } 
        long res = helper(hash, src, dst, K, seen, 0);
        return (res >= Integer.MAX_VALUE) ? -1 : (int) res;
    }
    public long helper(HashMap<Integer, List<int[]>> hash, int src, int dst, int K, HashMap<Pair<Integer, Integer>, Long> seen, int cost) {
        if(K < -1) {
            return Integer.MAX_VALUE;
        }
        
        if(src == dst) {
            return 0;
        }
        
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(src, K);
        if(seen.containsKey(key)) {
            return seen.get(key);
        }
        long curMin = Integer.MAX_VALUE;
        for(int[] next : hash.get(src)) {
            long money = helper(hash, next[0], dst, K - 1, seen, 0);
            curMin = Math.min(curMin, next[1] + money); 
        }
        seen.put(key, curMin);
        return curMin;
    }
}