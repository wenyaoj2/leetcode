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
class ClosestValue {
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
    public int closestValue(TreeNode root, double target) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(root.left == null) {
            int r = closestValue(root.right, target);
            return (Math.abs(root.val - target) < Math.abs(r - target)) ? root.val : r;
        }
        if(root.right == null) {
            int l = closestValue(root.left, target);
            return (Math.abs(root.val - target) < Math.abs(l - target)) ? root.val : l;
        }
        int l = closestValue(root.left, target);
        int r = closestValue(root.right, target);
        int min = 0;
        if(Math.abs(l - target) < Math.abs(r - target)) {
            min = l;
        }
        else {
            min = r;
        }
        return (Math.abs(root.val - target) < Math.abs(min - target)) ? root.val : min;
    }
}