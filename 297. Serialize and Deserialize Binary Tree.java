/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return traverse(root);
    }
    
    public String traverse(TreeNode root) {
        if(root == null) {
            return "null,";
        }
        String l = traverse(root.left);
        String r = traverse(root.right);
        return String.valueOf(root.val) + "," + l + r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return construct(nodes);
    }
    
    public TreeNode construct(String[] nodes) {
        if(nodes[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(nodes[index++]));
        node.left = construct(nodes);
        node.right = construct(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));