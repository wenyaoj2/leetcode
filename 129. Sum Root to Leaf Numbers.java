import java.util.*;

class SumNumbersFromRoot {
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
    List<Integer> list = new ArrayList();
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        int res = 0;
        for(int l : list) {
            res += l;
        }
        return res;
    }
    public void helper(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(val * 10 + root.val);
            return;
        }
        helper(root.left, val * 10 + root.val);
        helper(root.right, val * 10 + root.val);
        return;
    }
}