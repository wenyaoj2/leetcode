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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        TreeNode(int x) { val = x; }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList();
        List<Integer> list1 = new ArrayList(), list2 = new ArrayList();
        traverse(root1, list1);
        traverse(root2, list2);
        int index1 = 0, index2 = 0;
        while(index1 < list1.size() || index2 < list2.size()) {
            int num1 = (index1 < list1.size()) ? list1.get(index1) : Integer.MAX_VALUE;
            int num2 = (index2 < list2.size()) ? list2.get(index2) : Integer.MAX_VALUE;
            if(num1 < num2) {
                result.add(num1);
                index1++;
            }
            else {
                result.add(num2);
                index2++;
            }
        }
        return result;
    }
    private void traverse(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}