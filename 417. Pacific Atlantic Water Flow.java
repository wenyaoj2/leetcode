import java.util.*;

class Solution {
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        char[][] markedMatrix = new char[m][n];
        for(int i = 0; i < m; i++) {
            bfsFindCell(matrix, markedMatrix, i, 0, 'P');
            bfsFindCell(matrix, markedMatrix, i, n - 1, 'A');
        }
        for(int j = 0; j < n; j++) {
            bfsFindCell(matrix, markedMatrix, 0, j, 'P');
            bfsFindCell(matrix, markedMatrix, m - 1, j, 'A');
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(markedMatrix[i][j] == 'B') {
                    result.add(new ArrayList(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    private void bfsFindCell(int[][] matrix, char[][] markedMatrix, int x, int y, char target) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        if(markedMatrix[x][y] == target || markedMatrix[x][y] == '\0') {
            markedMatrix[x][y] = target;
        }
        else {
            markedMatrix[x][y] = 'B';
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < dirX.length; i++) {
                int row = dirX[i] + cur[0];
                int col = dirY[i] + cur[1];
                if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] < matrix[cur[0]][cur[1]] || markedMatrix[row][col] == target || markedMatrix[row][col] == 'B') {
                    continue;
                }
                if(markedMatrix[row][col] == target || markedMatrix[row][col] == '\0') {
                markedMatrix[row][col] = target;
            }
                else {
                    markedMatrix[row][col] = 'B';
                }
                queue.offer(new int[]{row, col});
            }
        }
    }
}