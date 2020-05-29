import java.util.*;

class CourseI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        HashMap<Integer, Integer> degree = new HashMap();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet());
            degree.put(i, 0);
        }
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            degree.put(prerequisite[0], degree.get(prerequisite[0]) + 1);
        }
        int num = 0;
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> seen = new HashSet();
        for(int course : degree.keySet()) {
            if(degree.get(course) == 0) {
                queue.offer(course);
                seen.add(course);
                num++;
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nei : graph.get(cur)) {
                if(seen.contains(nei)) {
                    continue;
                }
                degree.put(nei, degree.get(nei) - 1);
                if(degree.get(nei) == 0) {
                    seen.add(nei);
                    queue.offer(nei);
                    num++;
                }
            }
        }
        return num == numCourses;
    }
}