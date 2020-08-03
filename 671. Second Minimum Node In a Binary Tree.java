import java.util.Arrays;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class FindSecondMinimumValue {
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
    long[] mins = new long[2];
    public int findSecondMinimumValue(TreeNode root) {
        Arrays.fill(mins, Long.MAX_VALUE);
        helper(root);
        long res = Math.max(mins[0], mins[1]);
        return (res == Long.MAX_VALUE) ? -1 : (int)res;
    }
    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        if(root.val < mins[0]) {
            mins[1] = mins[0];
            mins[0] = (long)root.val;
        }
        else if(root.val > mins[0] && root.val < mins[1]) {
            mins[1] = (long)root.val;
        }
    }
}