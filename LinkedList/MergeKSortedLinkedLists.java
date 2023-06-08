package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeKSortedLinkedLists {


  public ListNode MergeKLinkedLists(ListNode[] lists,int start,int end){

      if(lists == null || lists.length == 0)
          return null;

        if(start == end){

            return lists[start];
        }

        int mid = start + (end-start)/2;

        ListNode left = MergeKLinkedLists(lists,start,mid);
        ListNode right = MergeKLinkedLists(lists, mid+1, end);

        return merge(left, right);

  }

  public ListNode merge(ListNode l1, ListNode l2){


        ListNode result = new ListNode(-1);

        ListNode current = result;

        while(l1 != null || l2 != null) {

            if (l1 == null && l2 != null) {
                current.next = l2;
                l2=l2.next;
            }

            else if(l1 != null && l2 == null){
                current.next = l1;
                l1 = l1.next;
            }

            else if(l1.val <l2.val){
                System.out.println("l1 < l2");
                System.out.println("arraay"+l1.val);
                System.out.println("arraa2"+l2.val);


                current.next = l1;
                l1 = l1.next;
            }

            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return result.next;
  }

  public static void main(String args[]){

        ListNode[] lists = new ListNode[2];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(2);
        lists[0].next.next = new ListNode(8);

        lists[1] = new ListNode(5);
        lists[1].next = new ListNode(7);

      MergeKSortedLinkedLists obj = new MergeKSortedLinkedLists();
      var arr = obj.MergeKLinkedLists(lists,0,lists.length-1);

  }


}
