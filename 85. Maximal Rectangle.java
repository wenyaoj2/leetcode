class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0){
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[j] = dp[j] + 1;
                }
                else{
                    dp[j] = 0;
                }
            }
            int cur = getMaxRectangle(dp);
            max = Math.max(max, cur);
        }
        return max;
    }
    
    public int getMaxRectangle(int[] dp){
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.add(-1);
        for(int i = 0; i < dp.length; i++){
            if(stack.peek() == -1 || dp[i] >= dp[stack.peek()]){
                stack.add(i);
            }
            else{
                while(stack.peek() != -1 && dp[i] < dp[stack.peek()]){
                    int cur = dp[stack.pop()] * (i - stack.peek() - 1);
                    max = Math.max(max, cur);
                }
                stack.add(i);
            }
        }
        while(stack.peek() != -1){
            int cur = dp[stack.pop()] * (dp.length - 1 - stack.peek());
            max = Math.max(max, cur);
        }
        return max;
    }
    
}