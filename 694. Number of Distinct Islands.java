import java.util.*;

class NumDistinctIslands {
    HashSet<String> res;
    int[] dirA = {1, 0, 0, -1};
    int[] dirB = {0, -1, 1, 0};
    public int numDistinctIslands(int[][] grid) {
        res = new HashSet();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    helper(grid, i, j);
                }
            }
        }
        return res.size();
    }
    public void helper(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        StringBuilder sb = new StringBuilder("00");
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < dirA.length; i++) {
                int row = cur[0] + dirA[i];
                int col = cur[1] + dirB[i];
                if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
                    continue;
                }
                sb.append(row - x);
                sb.append(col - y);
                grid[row][col] = 0;
                queue.offer(new int[]{row, col});
            }
        }
        String s = sb.toString();
        res.add(s);
    }
}