import java.util.*;

class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a,  int[] b) {
                return a[1] - b[1];
            }
        };
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, comparator);
        int[] dp = new int[intervals.length];
        int res = 1;
        dp[0] = 1;
        for(int i = 1; i < intervals.length; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(intervals[j][1] <= intervals[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }
        return intervals.length - res;
    }
}