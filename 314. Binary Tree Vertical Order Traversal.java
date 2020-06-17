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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Pair {
        TreeNode node;
        int val;
        public Pair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }
    HashMap<Integer, List<Integer>> hash;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        hash = new HashMap();
        int minCol = 0;
        int maxCol = 0;
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(root, 0));
        hash.put(0, new ArrayList());
        hash.get(0).add(root.val);
        while(!queue.isEmpty()) {
            int len = queue.size();
            Pair cur = queue.poll();
            minCol = Math.min(minCol, cur.val);
            maxCol = Math.max(maxCol, cur.val);
            if(cur.node.left != null) {
                hash.putIfAbsent(cur.val - 1, new ArrayList());
                hash.get(cur.val - 1).add( cur.node.left.val);
                queue.offer(new Pair(cur.node.left, cur.val - 1));
            }
            if(cur.node.right != null) {
                hash.putIfAbsent(cur.val + 1, new ArrayList());
                hash.get(cur.val + 1).add( cur.node.right.val);
                queue.offer(new Pair(cur.node.right, cur.val + 1));
            }
        }
        for(int i = minCol; i <= maxCol; i++) {
            res.add(hash.get(i));
        }
        return res;
    }
}