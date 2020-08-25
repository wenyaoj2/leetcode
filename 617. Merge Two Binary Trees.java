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
class MergeTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t = new TreeNode();
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null) {
            return t2;
        }
        else if(t2 == null) {
            return t1;
        }
        else {
            t.val = t1.val + t2.val;
        }
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
}