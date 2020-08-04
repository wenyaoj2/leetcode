import java.util.*;

class ShortestPathBinaryMatrix {
    int[] dirA = {0, 0, -1, -1, -1, 1, 1, 1};
    int[] dirB = {-1, 1, 0, 1, -1, 0, 1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) {
            return -1;
        }
        int res = 1;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    return res;
                }
                for(int j = 0; j < dirA.length; j++) {
                    int row = cur[0] + dirA[j];
                    int col = cur[1] + dirB[j];
                    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 1) {
                        continue;
                    }
                    grid[row][col] = 1;
                    queue.offer(new int[]{row, col});
                }
            }
            res++;
        }
        return -1;
    }
}