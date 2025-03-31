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

        Node newNode = new Node(insertVal);

        Node cur = head;
        

        if(head==null){
            head = newNode;
            head.next=newNode; 
            return head;
        }

        while(true){
            if(insertVal>=cur.val && insertVal<=cur.next.val){
                break;
            }

            if(cur.val>cur.next.val){
                if(insertVal>=cur.val || insertVal<=cur.next.val){
                    break;
                }

            }

            cur = cur.next;

            if(cur==head){
                break;
            }
        }

        Node next = cur.next;
        cur.next=  newNode;
        newNode.next = next;

        return head;

      

       
    }

}
