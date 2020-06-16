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
class ReverseBetween {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int index = 1;
        ListNode headReverse = dummy;
        while(index < m) {
            headReverse = head;
            head = head.next;
            index++;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(index <= n) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            index++;
        }
        headReverse.next = prev;
        head.next = cur;
        return dummy.next;
    }
}