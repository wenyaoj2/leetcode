class CalculateMinimumHP {
    class Pair {
        int down;
        int right;
        public Pair(int down, int right) {
            this.down = down;
            this.right = right;
        }
    }
    public int calculateMinimumHP(int[][] dungeon) {
        Pair[][] dp = new Pair[dungeon.length][dungeon[0].length];
        int l = dungeon[dungeon.length - 1][dungeon[0].length - 1];
        int lastRight = 0;
        int lastDown = 0;
        if(l > 0) {
            lastRight = 1;
            lastDown = 1;
        }
        else {
            lastRight = 1 - l;
            lastDown = 1 - l;
        }
        dp[dungeon.length - 1][dungeon[0].length - 1] = new Pair(lastDown, lastRight);
        for(int i = dungeon.length - 1; i >= 0; i--) {
            for(int j = dungeon[0].length - 1; j >= 0; j--) {
                if(i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    continue;
                }
                else if(i == dungeon.length - 1) {
                    Pair pre = dp[i][j+1];
                    int right = (pre.right - dungeon[i][j]) <= 0 ? 1 : pre.right - dungeon[i][j];
                    dp[i][j] = new Pair(Integer.MAX_VALUE, right);
                }
                else if(j == dungeon[0].length - 1) {
                    Pair pre = dp[i+1][j];
                    int down = (pre.down - dungeon[i][j]) <= 0 ? 1 : pre.down - dungeon[i][j];
                    dp[i][j] = new Pair(down, Integer.MAX_VALUE);
                }
                else {
                    Pair preRightP = dp[i][j+1];
                    Pair preDownP = dp[i+1][j];
                    int preRight = Math.min(preRightP.right, preRightP.down);
                    int preDown = Math.min(preDownP.right, preDownP.down);
                    int right = (preRight - dungeon[i][j]) <= 0 ? 1 : preRight - dungeon[i][j];
                    int down = (preDown - dungeon[i][j]) <= 0 ? 1 : preDown - dungeon[i][j];
                    dp[i][j] = new Pair(down, right);
                }
            }
        }
        return Math.min(dp[0][0].right, dp[0][0].down);
    }
}