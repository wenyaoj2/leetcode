import java.util.*;

class ShortestDistance {
    class Pair {
        int times;
        int val;
        public Pair(int times, int val) {
            this.times = times;
            this.val = val;
        }
    }
    int[] dirA = {0, 0, 1, -1};
    int[] dirB = {1, -1, 0, 0};
    public int shortestDistance(int[][] grid) {
        Pair[][] pairs = new Pair[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                pairs[i][j] = new Pair(0, 0);
            }
        }
        int num = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    num++;
                    int[][] seen = new int[grid.length][grid[0].length];
                    helper(grid, i, j, pairs, seen);
                }
                
            }
        }
        for(int i = 0; i < pairs.length; i++) {
            for(int j = 0; j < pairs[0].length; j++) {
                if(pairs[i][j] == null) {
                    continue;
                }
                Pair pair = pairs[i][j];
                if(pair.times == num) {
                    min = Math.min(min, pair.val);
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
    public void helper(int[][] grid, int x, int y, Pair[][] pairs, int[][] seen) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        int dis = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                if(grid[cur[0]][cur[1]] == 0) {
                    Pair p = pairs[cur[0]][cur[1]];
                    p.times += 1;
                    p.val += dis;
                }
                for(int j = 0; j < 4; j++) {
                    int row = cur[0] + dirA[j];
                    int col = cur[1] + dirB[j];
                    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 0 || seen[row][col] == 1) {
                        continue;
                    }
                    seen[row][col] = 1;
                    queue.offer(new int[]{row, col});
                }
                
            }
            dis += 1;
        }
    }
}