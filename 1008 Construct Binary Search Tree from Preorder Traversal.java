import java.util.Stack;

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
// Recursion
class ConstructBinarySearchTreefromPreorderTraversal {
    int pre_index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }
    
    public TreeNode helper(int lower, int upper, int[] preorder){
        if(pre_index >= preorder.length){
            return null;
        }
        int rootVal = preorder[pre_index];
        if(rootVal < lower || rootVal > upper){
            return null;
        }
        TreeNode root = new TreeNode(rootVal);
        pre_index++;
        root.left = helper(lower, rootVal, preorder);
        root.right = helper(rootVal, upper, preorder);
        return root;
    }
}

//  stack iteration
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        for(int i = 1;  i < preorder.length; i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(preorder[i] < stack.peek().val){
                stack.peek().left = node;
                stack.add(node);
            }
            else{
                TreeNode parent = new TreeNode(0);
                while(!stack.isEmpty() && preorder[i] > stack.peek().val){
                    parent = stack.pop();
                    
                }
                parent.right = node;
                // System.out.println(parent.val);
                stack.add(node);
            }
        }
        return root;
    }
}