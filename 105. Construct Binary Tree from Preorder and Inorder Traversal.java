import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    class TreeNode {
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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1, hash);
    }
    public TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> hash) {
        if(start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        int mid = hash.get(preorder[index++]);
        node.left = helper(preorder, start, mid - 1, hash);
        node.right = helper(preorder, mid + 1, end, hash);
        return node;
    }
}