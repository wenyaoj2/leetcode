import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dirA = {0,0,1,-1};
        int[] dirB = {1,-1,0,0};
        int[] cur = {sr, sc};
        int standard = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        Queue<int[]> queue = new LinkedList();
        queue.offer(cur);
        visited[sr][sc] = 1;
        image[cur[0]][cur[1]] = newColor;
        while(!queue.isEmpty()){
            int[] curCor = queue.poll();
            for(int i = 0; i < dirA.length; i++){
                int row = curCor[0] + dirA[i];
                int col = curCor[1] + dirB[i];
                if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || visited[row][col] == 1 || image[row][col] != standard){
                    continue;
                }
                visited[row][col] = 1;
                image[row][col] = newColor;
                queue.offer(new int[]{row, col});
            }
        }
        return image;
    }
}