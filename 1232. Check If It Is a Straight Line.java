import java.util.*;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        Arrays.sort(coordinates, comparator);
        int slope = 0;
        if(coordinates[1][0] == coordinates[0][0]) {
            slope = Integer.MIN_VALUE;
        }
        else{
            slope = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        }
        int x = coordinates[1][0];
        int y = coordinates[1][1];
        for(int i = 2; i < coordinates.length; i++) {
            if(slope == Integer.MIN_VALUE) {
                if(coordinates[i][0] != x) {
                    return false;
                }
                continue;
            }
            else {
                if(coordinates[i][0] == x) {
                    return false;
                }
                int curSlope = (coordinates[i][1] - y) / (coordinates[i][0] - x);
                if(curSlope != slope) {
                    return false;
                }
                x = coordinates[i][0];
                y = coordinates[i][1];
            }
        }
        return true;
    }
}