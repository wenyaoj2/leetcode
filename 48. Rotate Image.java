class Rotate {
    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(newMatrix[i][j] == 1) {
                    continue;
                }
                int row = j;
                int col = matrix[0].length - 1 - i;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row][col];
                matrix[row][col] = temp;
                newMatrix[row][col] = 1;
            }
        }
    }
}