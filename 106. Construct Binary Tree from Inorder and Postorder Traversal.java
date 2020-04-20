import java.util.HashMap;

class TreeNode {
         int val;
        TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
class ConstructBinaryTreefromInorderandPostorderTraversal {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        HashMap<Integer, Integer> hash = new HashMap();
        for(int i = 0; i < postorder.length; i++){
            hash.put(inorder[i], i);
        }
        return helper(0, postorder.length-1, inorder, postorder, hash);
    }
    
    public TreeNode helper(int start, int end, int[] inorder, int[] postorder, HashMap<Integer, Integer> hash){
        if(start > end){
            return null;
        }
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = hash.get(rootVal);
        index--;
        root.right = helper(inIndex+1, end, inorder, postorder, hash);
        root.left = helper(start, inIndex-1, inorder, postorder, hash);
        return root;
    }
}