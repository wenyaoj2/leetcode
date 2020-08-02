import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while(l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stack = new Stack();
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = (!stack1.isEmpty()) ? stack1.pop() : 0;
            int num2 = (!stack2.isEmpty()) ? stack2.pop() : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            stack.add(sum % 10);
        }
        if(carry > 0) {
            stack.add(carry);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return dummy.next;
    }
}