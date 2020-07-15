import java.util.*;

class MaxAreaOfIsland {
    int max = 0;
    int[][] seen;
    int[] dirA = {0, 0, 1, -1};
    int[] dirB = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        seen = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && seen[i][j] == 0) {
                    seen[i][j] = 1;
                    int num = helper(grid, seen, i, j);
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }
    public int helper(int[][] grid, int[][] seen, int x, int y) {
        int num = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            num++;
            for(int i = 0; i < dirA.length; i++) {
                int row = cur[0] + dirA[i];
                int col = cur[1] + dirB[i];
                if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || seen[row][col] == 1) {
                    continue;
                }
                seen[row][col] = 1;
                queue.offer(new int[]{row, col});
            }
        }
        return num;
    }
}