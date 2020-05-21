import java.util.*;

class CourseII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> hash = new HashMap();
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < numCourses; i++) {
            hash.put(i, 0);
            graph.put(i, new HashSet());
        }
        for(int[] prerequisite : prerequisites) {
            hash.put(prerequisite[0], hash.get(prerequisite[0]) + 1);
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList();
        List<Integer> res = new ArrayList();
        for(int i : hash.keySet()) {
            if(hash.get(i) == 0) {
                queue.offer(i);
                res.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int curCourse = queue.poll();
            for(int next : graph.get(curCourse)) {
                hash.put(next, hash.get(next) - 1);
                if(hash.get(next) == 0) {
                    queue.offer(next);
                    res.add(next);
                }
            }
        }
        int[] ans = new int[numCourses];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return (res.size() == numCourses) ? ans : new int[0];
    }
}