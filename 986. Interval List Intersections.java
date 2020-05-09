import java.util.*;

class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList();
        int index1 = 0;
        int index2 = 0;
        while(index1 < A.length && index2 < B.length) {
            int low = Math.max(A[index1][0], B[index2][0]);
            int high = Math.min(A[index1][1], B[index2][1]);
            if(high >= low) {
                list.add(new int[]{low, high});
            }
            if(A[index1][1] < B[index2][1]) {
                index1++;
            }
            else {
                index2++;
            }
            
        }
        int[][] ans = new int[list.size()][2];
        int index = 0;
        for(int[] a : list) {
            ans[index][0] = a[0];
            ans[index++][1] = a[1];
        }
        return ans;
    }
}