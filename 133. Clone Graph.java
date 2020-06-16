import java.util.*;

class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node, Node> hash = new HashMap();
        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        hash.put(node, new Node(node.val));
        while(!queue.isEmpty()) {
            List<Node> curNei = new ArrayList();
            Node cur = queue.poll();
            for(Node n : cur.neighbors) {
                if(!hash.containsKey(n)) {
                    Node newN = new Node(n.val);
                    hash.put(n, newN);
                    curNei.add(newN);
                    queue.offer(n);
                }
                else {
                    curNei.add(hash.get(n));
                }
            }
            Node curNode = hash.get(cur);
            curNode.neighbors = curNei;
        }
        return hash.get(node);
    }
}