import java.util.*;

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty() && asteroids[i] < 0) {
                list.add(asteroids[i]);
            }
            else if(!stack.isEmpty() && asteroids[i] < 0) {
                while(!stack.isEmpty() && asteroids[i] + stack.peek() < 0) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    list.add(asteroids[i]);
                }
                else if(stack.peek() + asteroids[i] == 0) {
                    stack.pop();
                }
            }
            else {
                stack.add(asteroids[i]);
            }
        }
        int[] res = new int[list.size() + stack.size()];
        int index = res.length - 1;
        while(!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        index = 0;
        for(int num : list) {
            res[index++] = num;
        }
        return res;
    }
}