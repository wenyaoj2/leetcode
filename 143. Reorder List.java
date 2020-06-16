/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = head;
        while(fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        tail.next = null;
        ListNode cur = slow;
        ListNode prev = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // System.out.println(head.val + " " + prev.next.val);
        ListNode dummy = new ListNode(0);
        cur = dummy;
        while(head != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = prev;
            prev = prev.next;
            cur = cur.next;
        }
        cur.next = prev;
        head = dummy.next;
    }
}