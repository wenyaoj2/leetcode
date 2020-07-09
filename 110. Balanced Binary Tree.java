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
class Solution {
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
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int l = helper(node.left);
        int r = helper(node.right);
        if(l == -1 || r == -1) {
            return -1;
        }
        return (Math.abs(l - r) <= 1) ? Math.max(l, r) + 1 : -1;
    }
}