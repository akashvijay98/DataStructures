/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //source NeetCode 

/*
    The idea is to put the elements less than x in a seperate linked list 
    and put elements greater than or equal to  x into a seperate list and then join both the lists

*/


class Solution {
    public ListNode partition(ListNode head, int x) {

        // initialise left and right linked list pointers

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode lTail = left;
        ListNode rTail = right;
        

        while(head != null){

            if(head.val >= x){
                // we'll point the tail of right linked list.
                rTail.next = head;
                rTail = rTail.next;
            }
            else{
                //we'll point the tail of left linked list'
                lTail.next=head;
                lTail = lTail.next;

            }
            head=head.next;
        }
        /* after the while loop finished, the we'll point the tail of left linked list(which is the last element of the left linked list )
            to the first element of the right linked list.
           
            *** right pointer will be a dummy value ( ListNode right = new ListNode(0) ) hence we point to r.next
        )

        */
        lTail.next = right.next;
        rTail.next=null;

        return left.next;



            
        
        
    }
}
