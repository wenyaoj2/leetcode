import java.util.*;

class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hash = new HashMap();
        Node dummy = new Node(0);
        Node cur = dummy;
        Node node = head;
        while(node != null) {
            Node newNode = new Node(node.val);
            cur.next = newNode;
            hash.put(node, newNode);
            node = node.next;
            cur = cur.next;
        }
        cur = dummy.next;
        node = head;
        while(node != null) {
            Node rand = node.random;
            if(rand == null) {
                cur.random = null;
            }
            else {
                Node newRand = hash.get(rand);
                cur.random = newRand;
            }
            cur = cur.next;
            node = node.next;
        }
        return dummy.next;
    }
}