import java.util.*;

class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList();
        int result = 0;
        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            queue.offer(i);
            visited[i] = 1;
            result++;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int j = 0; j < M[0].length; j++) {
                    if(M[cur][j] == 1 && visited[j] == 0) {
                        queue.offer(j);
                        visited[j] = 1;
                    }
                }
            }
        }
        return result;
    }
}