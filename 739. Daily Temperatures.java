import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[T.length];
        for(int i = 0; i < T.length; i++){
            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.add(i);
            }
            else{
                while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                    int num = i - stack.peek();
                    ans[stack.pop()] = num;
                }
                stack.add(i);
            }
        }
        return ans;
    }
}