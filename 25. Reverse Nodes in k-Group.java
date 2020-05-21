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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        while(cur != null) {
            ListNode nextNode = cur.next;
            ListNode node = reverse(cur, k);
            if(node == null) {
                break;
            }
            cur.next = node;
            cur = nextNode;
            // System.out.println(nextNode.next.val);
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode node, int k) {
        ListNode n1 = node.next;
        while(k > 0) {
            node = node.next;
            if(node == null) {
                return null;
            }
            k--;
        }
        ListNode nFirst = n1;
        ListNode nLast = node;
        ListNode nLastMax = node.next;
        ListNode prev = null;
        while(n1 != nLastMax) {
            ListNode temp = n1.next;
            n1.next = prev;
            prev = n1;
            n1 = temp;
        }
        nFirst.next = nLastMax;
        return nLast;
    }
}