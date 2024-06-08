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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)-> a.val - b.val );

        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        for(ListNode node: lists){
            if(node != null){
                heap.offer(node);

            }
        }

        while(!heap.isEmpty()){
            cur.next = heap.poll();

            cur = cur.next;

            if(cur.next != null){
                heap.add(cur.next);
            }
        }
        return head.next;
    }
}
