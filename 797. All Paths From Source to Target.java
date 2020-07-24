import java.util.*;

class AllPathsSourceTarget {
    HashMap<Integer, List<List<Integer>>> memo = new HashMap();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, List<Integer>> hash = new HashMap();
        for(int i = 0; i < graph.length; i++) {
            hash.putIfAbsent(i, new ArrayList());
            int[] edges = graph[i];
            for(int edge : edges) {
                hash.get(i).add(edge);
            }
        }
        HashSet<Integer> seen = new HashSet();
        seen.add(0);
        return helper(hash, 0, seen, graph.length - 1);
    }
    private List<List<Integer>> helper(HashMap<Integer, List<Integer>> hash, int curNode, HashSet<Integer> seen, int target) {
        List<List<Integer>> result = new ArrayList();
        if(curNode == target) {
            List<Integer> newPath = new ArrayList();
            newPath.add(curNode);
            result.add(new ArrayList(newPath));
            return result;
        }
        if(memo.containsKey(curNode)) {
            return memo.get(curNode);
        }
        for(int next : hash.get(curNode)) {
            if(seen.contains(next)) {
                continue;
            }
            seen.add(next);
            // curList.add(next);
            List<List<Integer>> list = helper(hash, next, seen, target);
            for(List<Integer> l : list) {
                List<Integer> newPath = new ArrayList();
                newPath.add(curNode);
                newPath.addAll(l);
                result.add(newPath);
            }
            seen.remove(next);
            // curList.remove(curList.size() - 1);
           
        }
        memo.put(curNode, result);
        return result;
        
    }
}