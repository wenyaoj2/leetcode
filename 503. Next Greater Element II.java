import java.util.*;

class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] newNums = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
            newNums[i + nums.length] = nums[i];
        }
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int num = 0;
        for(int i = 0; i < newNums.length; i++) {
            while(!stack.isEmpty() && newNums[stack.peek()] < newNums[i]) {
                int index = stack.pop();
                if(index < nums.length) {
                    num++;
                    res[index] = newNums[i];
                }
            }
            stack.add(i);
        }
        return res;
    }
}