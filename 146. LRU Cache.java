import java.util.HashMap;

class LRUCache {
    class ListNode{
        ListNode prev;
        ListNode next;
        int val;
        int key;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    int capacity;
    int size;
    HashMap<Integer, ListNode> hash;
    public LRUCache(int capacity) {
        hash = new HashMap();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        this.capacity = capacity;
        size = 0;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)){
            return -1;
        }
        ListNode node = hash.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            ListNode node = hash.get(key);
            node.val = value;
            moveToHead(node);
            hash.put(key, node);
            return;
        }
        ListNode node = new ListNode(key, value);
        if(size < capacity){
            addToHead(node);
            hash.put(key, node);
            size++;
            return;
        }
        else{
            ListNode t = removeTail();
            hash.remove(t.key);
            addToHead(node);
            hash.put(key, node);
            return;
        }
    }
    
    public void addToHead(ListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    public void moveToHead(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    public ListNode removeTail(){
        ListNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */