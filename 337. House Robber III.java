/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RobHouseIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        int[] num = helper(root);
        return Math.max(num[0], num[1]);
    }
    private int[] helper(TreeNode node) {
        int[] res = new int[2];
        if(node == null) {
            return res;
        }
        int[] l = helper(node.left);
        int[] r = helper(node.right);
        res[0] = node.val + l[1] + r[1];
        res[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return res;
    }
}