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
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root);
    }
    public TreeNode helper(TreeNode node) {
        if(node.left == null && node.right == null) {
            return node;
        }
        if(node.left == null) {
            return helper(node.right);
        }
        if(node.right == null) {
            TreeNode l = helper(node.left);
            node.right = node.left;
            node.left = null;
            return l;
        }
        TreeNode l = helper(node.left);
        TreeNode r = helper(node.right);
        l.right = node.right;
        node.right = node.left;
        node.left = null;
        return r;
    }
}