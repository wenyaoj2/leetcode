import java.util.*;

class HasPath {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {1, -1, 0, 0};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            for(int i = 0; i < dirX.length; i++) {
                int row = cur[0] + dirX[i];
                int col = cur[1] + dirY[i];
                // System.out.println(row + " " + col);
                while(row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0) {
                    row += dirX[i];
                    col += dirY[i];
                }
                row -= dirX[i];
                col -= dirY[i];
                if(visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                
                queue.offer(new int[]{row, col});
            }
        }
        return false;
    }
}