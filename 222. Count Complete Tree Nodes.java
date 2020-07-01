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
class CountNodes {
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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int d = depth(root);
        int start = 0;
        int end = (int) (Math.pow(2, d - 1)) - 1;
        while(start  + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(helper(root, mid, d)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(helper(root, end, d)) { 
            return (int) (Math.pow(2, d - 1)) + end;
        }
        return (int) (Math.pow(2, d - 1)) + start;
    }
    public boolean helper(TreeNode root, int target, int d) {
        int start = 0;
        int end = (int) (Math.pow(2,  d - 1)) - 1;
        while(d > 1) {
            int mid = (end - start) / 2 + start;
            if(mid >= target) {
                root = root.left;
                end = mid;
            }
            else {
                root = root.right;
                start = mid;
            }
            d--;
        }
        return root != null;
    }
    public int depth(TreeNode root) {
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}