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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        int carry =0;
        // imagine l1 = [9,9,9,9,9,9,9] and l2 =[9,9,9,9]
        // in the end l1 will be null and l2 will be null but carry will be equals to 1
        // hence code will enter while loop to give result [8,9,9,9,0,0,0,1]
        // if we dont add condition carry!=0, result would stop at  [8,9,9,9,0,0,0]
        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null)?l1.val:0;
            int y = (l2 != null)?l2.val:0;

            int sum = carry+x+y;

            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1 != null){
                l1 = l1.next;

            }
            if(l2 != null){
                l2 = l2.next;

            }

        }

        return head.next;
    }
}
