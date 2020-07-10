class Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        helper(head);
        
        return head;
    }
    public Node helper(Node node) {
        Node cur = node;
        Node prev = null;
        while(cur != null) {
            Node next = cur.next;
            if(cur.child != null) {
                Node nextLevel = helper(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                nextLevel.next = next;
                prev = nextLevel;
                if(next != null)
                    next.prev = nextLevel;
                cur = next;
            }
            else {
                prev = cur;
                cur = next;
            }
            
        }
        return prev;
    }
}