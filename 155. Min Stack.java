import java.util.Stack;

class MinStack {
    class Pair {
        int val;
        int min;
        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.add(new Pair(x, x));
            return;
        }
        stack.add(new Pair(x, Math.min(x, stack.peek().min)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
