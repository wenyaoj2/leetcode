class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N];
        for(int[] t : trust) {
            trusts[t[1] - 1] += 1;
            trusts[t[0] - 1] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < N; i++) {
            if(trusts[i] == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}