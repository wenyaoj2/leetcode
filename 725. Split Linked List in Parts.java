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
class SplitListToParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int num = 0;
        ListNode cur = root;
        while(cur != null) {
            cur = cur.next;
            num++;
        }
        ListNode[] res = new ListNode[k];
        int remainder = num % k;
        int n = num / k;
        for(int i = 0; i < k; i++) {
            if(n == 0 && remainder == 0) {
                res[i] = null;
            }
            else {
                ListNode prev = null;
                res[i] = root;
                int temp = n;
                while(temp > 0) {
                    prev = root;
                    root = root.next;
                    temp--;
                }
                if(remainder > 0) {
                    prev = root;
                    root = root.next;
                    remainder--;
                }
                prev.next = null;
            }
        }
        return res;
    }
}