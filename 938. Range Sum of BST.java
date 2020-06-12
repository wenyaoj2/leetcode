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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        int left = (root.val <= L) ? 0 : rangeSumBST(root.left, L, R);
        int right = (root.val >= R) ? 0 : rangeSumBST(root.right, L, R);
        if(root.val >= L && root.val <= R) {
            return left + root.val + right;
        }
        return left + right;
    }
}