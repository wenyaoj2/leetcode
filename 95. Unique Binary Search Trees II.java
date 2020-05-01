import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList();
        }
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }
}