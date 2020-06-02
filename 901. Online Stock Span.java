import java.util.*;

class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    public StockSpanner() {
        stack = new Stack();
        list = new ArrayList();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            stack.add(list.size());
            list.add(price);
            return list.size();
        }
        int res = list.size() - stack.peek();
        stack.add(list.size());
        list.add(price);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */