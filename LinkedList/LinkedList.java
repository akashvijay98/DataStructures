package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void insert(int data){

        Node current = new Node(data);

        if(head == null){
            head = current;
        }
        else{
            Node p = head;

            while(p!= null && p.next != null){
                p=p.next;
            }
            p.next = current;
        }
    }

    public void insertBeginning(int data){
        Node current  = new Node(data);
        if(head==null){
            head = current;
        }
        else{
            current.next= head;
            head = current;
        }
    }
    public List<Integer> read(){
        List<Integer> dataList = new ArrayList<>();
        Node cur = head;
        while(cur != null){
            dataList.add(cur.data);
            cur=cur.next;

        }
        return dataList;
    }

    public void insertAtIndex(int data, int index){
        //Need to modify this function to add elements at the beginning
        Node current = new Node(data);

        Node p=head;

        int hop = 0;
        while(hop<index-1){
            p=p.next;
            hop+=1;

        }
        Node q = p.next;

        p.next= current;
        current.next = q;
    }
    public void removeAtBeginning(){
        Node cur = head;
       // System.out.print("curr==="+head);
        head = cur.next;
        cur.next = null;

    }
    public void removeAtEnd() {
        Node cur = head;

    }

        public static void main(String[] args){
       LinkedList l = new LinkedList();
       l.insert(1);
       l.insert(2);
       l.insert(23);
       l.insertBeginning(4);
       l.insertBeginning(5);
       l.insertAtIndex(8,2);
       l.insertAtIndex(80,1);
       l.removeAtBeginning();

       List<Integer> lst =  l.read();
       System.out.print(lst);

    }

}

