
class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }
    public ListNode divide(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        return mergeSort(left, right);
    }
    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null) ? right : left;
        return dummy.next;
    }
}