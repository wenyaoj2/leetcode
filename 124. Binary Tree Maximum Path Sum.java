class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftVal = Math.max(0, helper(root.left));
        int rightVal = Math.max(0, helper(root.right));
        int curVal = Math.max(root.val + leftVal, root.val + rightVal);
        max = Math.max(Math.max(max, curVal), root.val + leftVal + rightVal);
        return curVal;
    }
}