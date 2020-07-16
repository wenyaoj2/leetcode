import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class NextLargerNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int num = 0;
        while(cur != null) {
            cur = cur.next;
            num++;
        }
        int[] res = new int[num];
        Stack<Pair> stack = new Stack();
        num = 0;
        while(head != null) {
            while(!stack.isEmpty() && head.val > stack.peek().val) {
                Pair p = stack.pop();
                res[p.index] = head.val;
            }
            stack.add(new Pair(num, head.val));
            head = head.next;
            num++;
        }
        return res;
    }
}