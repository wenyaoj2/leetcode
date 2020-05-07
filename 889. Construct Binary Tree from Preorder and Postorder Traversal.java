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
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> hashPre = new HashMap();
        HashMap<Integer, Integer> hashPos = new HashMap();
        for(int i = 0; i < pre.length; i++){
            hashPre.put(pre[i], i);
            hashPos.put(post[i], i);
        }
        return helper(0, pre.length - 1, pre, post, hashPre, hashPos);
    }
    public TreeNode helper(int start, int end, int[] pre, int[] post, HashMap<Integer, Integer> hashPre, HashMap<Integer, Integer> hashPos){
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(pre[start]);
        if(start == end){
            return node;
        }
        int postIndex = hashPos.get(pre[start]) - 1;
        int rightIndex = hashPre.get(post[postIndex]);
        node.left = helper(start + 1, rightIndex - 1, pre, post, hashPre, hashPos);
        node.right = helper(rightIndex, end, pre, post, hashPre, hashPos);
        return node;
    }
}