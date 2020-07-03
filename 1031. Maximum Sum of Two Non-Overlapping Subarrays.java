class MaxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        int res = sums[L + M - 1];
        int[] left = new int[A.length];
        left[L + M - 1] = sums[L - 1];
        for(int i = L + M; i < A.length; i++) {
            int curSum = sums[i - M] - sums[i - L - M];
            left[i] = Math.max(left[i - 1], curSum);
            res = Math.max(res, left[i] + sums[i] - sums[i - M]);
        }
        int[] right = new int[A.length];
        right[L + M - 1] = sums[M - 1];
        for(int i = L + M; i < A.length; i++) {
            int curSum = sums[i - L] - sums[i - M - L];
            right[i] = Math.max(right[i - 1], curSum);
            res = Math.max(res, right[i] + sums[i] - sums[i - L]);
        }
        return res;
    }
}