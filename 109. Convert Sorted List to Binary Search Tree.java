import java.util.*;
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<ListNode> list = new ArrayList();
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int end = 0;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
            end++;
        }
        return helper(0, end - 1);
    }
    public TreeNode helper(int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        ListNode cur = list.get(mid);
        TreeNode node = new TreeNode(cur.val);
        if(start == end) {
            return node;
        }
        node.left = helper(start, mid - 1);
        node.right = helper(mid + 1, end);
        return node;
    }
}