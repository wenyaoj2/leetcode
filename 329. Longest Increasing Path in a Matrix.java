class LongestIncreasingPath {
    int[][] cache;
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, helper(matrix, i, j));
            }
        }
        return result;
    }
    private int helper(int[][] matrix, int x, int y) {
        if(cache[x][y] != 0) {
            return cache[x][y];
        }
        int max = 0;
        for(int i = 0; i < dirX.length; i++) {
            int row = dirX[i] + x;
            int col = dirY[i] + y;
            if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= matrix[x][y]) {
                continue;
            }
            int temp = helper(matrix, row, col);
            max = Math.max(max, temp);
        }
        cache[x][y] = max + 1;
        return max + 1;
    }
}