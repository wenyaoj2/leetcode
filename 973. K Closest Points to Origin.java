class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        K = K - 1;
        int start = 0;
        int end = points.length - 1;
        while(start <= end) {
            int n = helper(points, start, end);
            if(n == K) {
                break;
            }
            else if(n > K) {
                end = n - 1;
            }
            else {
                start = n + 1;
            }
        }
        for(int i = 0; i <= K; i++) {
            res[i] = points[i];
        }
        return res;
    }
    public int helper(int[][] points, int start, int end) {
        if(start >= end) {
            return start;
        }
        int pivot = start;
        int pivotVal = points[start][0] * points[start][0] + points[start][1] * points[start][1];
        while(start <= end) {
            while(start <= end && points[start][0] * points[start][0] + points[start][1] * points[start][1] <= pivotVal) {
                start++;
            }
            while(start <= end && points[end][0] * points[end][0] + points[end][1] * points[end][1] > pivotVal) {
                end--;
            }
            if(start <= end) {
                int[] temp = points[start].clone();
                int[] temp1 = points[end].clone();
                points[start] = temp1;
                points[end] = temp;
                start++;
                end--;
                
            }
        }
        int[] temp = points[end].clone();
        int[] temp1 = points[pivot].clone();
        points[end] = temp1;
        points[pivot] = temp;
        return end;
    }
}