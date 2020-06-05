class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        int sum = 0;
        for(int num : A) {
            sum += num;
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
        }
        int min = 0;
        int curMin = 0;
        for(int i = 0; i < A.length - 1; i++) {
            curMin = Math.min(curMin + A[i], A[i]);
            min = Math.min(min, curMin);
        }
        curMin = 0;
        for(int i = 1; i < A.length; i++) {
            curMin = Math.min(curMin + A[i], A[i]);
            min = Math.min(min, curMin);
        }
        return Math.max(max, sum - min);
    }
}