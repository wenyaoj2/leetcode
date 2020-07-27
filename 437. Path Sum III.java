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
class PathSumIII {
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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + helper(root, sum);
    }
    public int helper(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int num = 0;
        if(sum == root.val) {
            num += 1;
        }
        num += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        return num;
    }
}