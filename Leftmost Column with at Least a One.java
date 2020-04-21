import java.util.List;

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = 0;
        int col = dimension.get(1) - 1;
        int min = Integer.MAX_VALUE;
        while(row < dimension.get(0) && col >= 0){
            if(binaryMatrix.get(row, col) == 0){
                row++;
            }
            else{
                min = col;
                col--;
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}