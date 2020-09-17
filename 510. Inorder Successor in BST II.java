/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node rightNode = node.right;
        Node parentNode = node.parent;
        if(rightNode == null && parentNode == null) {
            return null;
        }
        else if(rightNode != null) {
            while(rightNode.left != null) {
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        while(parentNode.parent != null && parentNode.val < node.val) {
            parentNode = parentNode.parent;
        }
        return parentNode.val < node.val ? null : parentNode;
    }
}