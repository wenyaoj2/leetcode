class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix[0].length - 1];
        while(start < end) {
            int mid = (end - start) / 2 + start;
            int[] range = new int[]{start, end};
            int counts = helper(matrix, mid, range);
            // System.out.println(counts + " " +mid);
            if(counts < k) {
                start = range[1];
            }
            else {
                end = range[0];
            }
        }
        return start;
    }
    public int helper(int[][] matrix, int target, int[] range) {
        int row = matrix.length - 1;
        int col = 0;
        int num = 0;
        while(row >= 0 && col < matrix[0].length) {
            // if(matrix[row][col] == target) {
            //     range[0] = matrix[row][col];
            // }
            if(matrix[row][col] <= target) {
                num += row + 1;
                range[0] = Math.max(range[0], matrix[row][col]);
                col++;
            }
            else {
                range[1] = Math.min(range[1], matrix[row][col]);
                row--;
            }
        }
        return num;
    }
}