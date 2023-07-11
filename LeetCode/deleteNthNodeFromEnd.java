package LeetCode;

public class deleteNthNodeFromEnd {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode start = new ListNode();
            start.next = head;
            ListNode fast = start;
            ListNode slow = start;


            for(int i = 1; i <= n; i++)
                fast = fast.next;


            while(fast.next != null){
                fast=fast.next;
                slow = slow.next;
            }

            ListNode nextNode = slow.next;
            slow.next = nextNode.next;
            nextNode =null;


            return start.next;



        }

}
