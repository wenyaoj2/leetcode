import java.util.*;

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList());
        }
        for(int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        HashMap<Integer, Integer> seen = new HashMap();
        for(int i = 1; i <= N; i++) {
            if(seen.containsKey(i)) {
                continue;
            }
            
            if(!helper(i, graph, seen, 1)) {
                return false;
            }
            
        }
        return true;
    }
    public boolean helper(int num, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> seen, int color) {
        if(seen.containsKey(num)) {
            return seen.get(num) == color;
        }
        seen.put(num, color);
        for(int neighbor : graph.get(num)) {
            if(!helper(neighbor, graph, seen, -color)) {
                return false;
            }
        }
        
        return true;
    }
}