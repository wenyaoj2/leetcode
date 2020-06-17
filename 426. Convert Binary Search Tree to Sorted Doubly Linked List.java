class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        Node[] res = helper(root);
        res[0].left = res[1];
        res[1].right = res[0];
        return res[0];
    }
    public Node[] helper(Node root) {
        if(root == null) {
            return new Node[]{null, null};
        }
        if(root.left == null && root.right == null) {
            return new Node[]{root, root};
        }
        Node[] left = helper(root.left);
        Node[] right = helper(root.right);
        if(root.left == null) {
            root.right = right[0];
            right[0].left = root;
            return new Node[]{root, right[1]};
        }
        else if(root.right == null) {
            root.left = left[1];
            left[1].right = root;
            return new Node[]{left[0], root};
        }
        else {
            root.right = right[0];
            right[0].left = root;
            root.left = left[1];
            left[1].right = root;
        }
        
        return new Node[]{left[0], right[1]};
    }
}