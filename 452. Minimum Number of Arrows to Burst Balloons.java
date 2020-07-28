import java.util.*;

class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, comparator);
        Stack<int[]> stack = new Stack();
        stack.add(points[0]);
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= stack.peek()[1]) {
                int[] cur = stack.pop();
                stack.add(new int[]{points[i][0], Math.min(cur[1], points[i][1])});
            }
            else {
                stack.add(points[i]);
            }
        }
        return stack.size();
    }
}