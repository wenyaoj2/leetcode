/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if(head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        Node prev = head;
        Node cur = head.next;
        do {
            if(prev.val <= insertVal && insertVal <= cur.val) {
                prev.next = insertNode;
                insertNode.next = cur;
                return head;
            }            
            else if(prev.val > cur.val) {
                if(insertVal >= prev.val || insertVal <= cur.val) {
                    prev.next = insertNode;
                    insertNode.next = cur;
                    return head;
                }
            }
            prev = cur;
            cur = cur.next;
        }while(prev != head);
        prev.next = insertNode;
        insertNode.next = prev;
        return head;
    }
}