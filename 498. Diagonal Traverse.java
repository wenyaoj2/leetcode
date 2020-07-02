import java.util.*;

class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int sum = 0;
        int index = 0;
        while(sum < rows + cols - 1) {
            int m = (sum < cols) ? 0 : sum - cols + 1;
            int n = (sum < cols) ? sum : cols - 1;
            List<Integer> temp = new ArrayList();
            while(m < rows && n >= 0) {
                temp.add(matrix[m][n]);
                m++;
                n--;
            }
            if(sum % 2 == 0) {
                Collections.reverse(temp);
            }
            for(int num : temp) {
                res[index++] = num;
            }
            sum++;
        }
        return res;
    }
}