class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }
    
    public boolean helper(TreeNode node, int[] arr, int index){
        if(node == null){
            return false;
        }
        if(index == arr.length - 1){
            if(node == null){
                return false;
            }
            return node.val == arr[index] && node.left == null && node.right == null;
        }

        if(node.val != arr[index]){
            return false;
        }
        
        boolean left = helper(node.left, arr, index+1);
        boolean right = helper(node.right, arr, index+1);
        return left || right;
    }
}