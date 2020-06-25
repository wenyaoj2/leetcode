class TrapRain {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
}