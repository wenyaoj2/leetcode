import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) {
            return res;
        }
        List<Integer> l = inorderTraversal(root.left);
        res.addAll(l);
        res.add(root.val);
        List<Integer> r = inorderTraversal(root.right);
        res.addAll(r);
        return res;
    }
}