class RandomPickWeight {
    int[] weights;
    int[] w;
    public RandomPickWeight(int[] w) {
        this.w = w;
        weights = new int[w.length];
        weights[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            weights[i] = weights[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random() * weights[weights.length - 1]) + 1;
        int start = 0;
        int end = weights.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(weights[mid] == rand) {
                return mid;
            }
            else if(weights[mid] < rand) {
                start = mid;
            }
            else {
                end = mid;
            }
        } 
        if(weights[start] >= rand) {
            return start;
        }
        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */