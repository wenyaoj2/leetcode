class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) {
            return 0;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        };
        Arrays.sort(pairs, comparator);
        int result = 0;
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for(int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}