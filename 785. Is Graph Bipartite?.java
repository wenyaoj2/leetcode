import java.util.*;

class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Integer> seen = new HashMap();
        for(int i = 0; i < graph.length; i++) {
            if(seen.containsKey(i)) {
                continue;
            }
            if(!helper(i, graph, seen, 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean helper(int node, int[][] graph, HashMap<Integer, Integer> seen, int group) {
        if(seen.containsKey(node)) {
            return group == seen.get(node);
        }
        seen.put(node, group);
        for(int nei : graph[node]) {
            if(!helper(nei, graph, seen, -group)) {
                return false;
            }
        }
        return true;
    }
}