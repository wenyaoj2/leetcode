import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class LargestValues {
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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = queue.size();
            for(int i =  0; i < len; i++) {
                TreeNode cur = queue.poll();
                max  = Math.max(max, cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right !=  null) {
                    queue.offer(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}