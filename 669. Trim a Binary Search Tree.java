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
class TrimBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return null;
        }
        TreeNode l = trimBST(root.left, L, R);
        TreeNode r = trimBST(root.right, L, R);
        if(root.val <= R && root.val >= L) {
            root.left = l;
            root.right = r;
            return root;
        }
        return (root.val < L) ? r : l;
    }
}