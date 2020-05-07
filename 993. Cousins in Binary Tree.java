import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int parent = -1;
        int depth = -1;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int curDepth = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            curDepth++;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(node.left.val == x || node.left.val == y){
                        if(parent == -1){
                            parent = node.val;
                            depth = curDepth;
                        }
                        else{
                            return depth == curDepth && parent != node.val;
                        }
                    }
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x || node.right.val == y){
                        if(parent == -1){
                            parent = node.val;
                            depth = curDepth;
                        }
                        else{
                            return depth == curDepth && parent != node.val;
                        }
                    }
                    queue.offer(node.right);
                }
            }
        }
        return false;
    }
}