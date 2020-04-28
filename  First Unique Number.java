import java.util.HashMap;

class FirstUnique {
    class ListNode {
        ListNode next;
        ListNode prev;
        int val;
        public ListNode(int val){
            this.val = val;
        }
    }
    HashMap<Integer, Integer> storeNum;
    HashMap<Integer, ListNode> hash;
    ListNode head;
    ListNode tail;
    public FirstUnique(int[] nums) {
        storeNum = new HashMap();
        hash = new HashMap();
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        for(int num : nums){
            add(num);
        }
       
    }
    
    public int showFirstUnique() {
        return head.next.val;
    }
    
    public void add(int value) {
        if(storeNum.containsKey(value) && storeNum.get(value) == 1){
            storeNum.put(value, storeNum.get(value) + 1);
            ListNode node = hash.get(value);
            removeNode(node);
            hash.remove(value);
        }
        else if(!storeNum.containsKey(value)){
            storeNum.put(value, 1);
            ListNode node = new ListNode(value);
            addNode(node);
            hash.put(value, node);
        }
        else{
            storeNum.put(value, storeNum.get(value) + 1);
        }
        return;
    }
    
    public void addNode(ListNode node){
        ListNode pre = tail.prev;
        node.prev = pre;
        node.next = tail;
        pre.next = node;
        tail.prev = node;
    }
    
    public void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}