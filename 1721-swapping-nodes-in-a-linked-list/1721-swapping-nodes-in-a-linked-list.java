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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for(int i=1;i<=k-1;i++){
            if(first==null) return head;
            first = first.next;
        }
        
        ListNode last = head;
        ListNode slow = head;
        
        for(int i=1;i<=k-1;i++){
            if(slow==null){
                return head;
            }
            slow = slow.next;
        }
        while(slow!=null && slow.next!=null){
            last = last.next;
            slow = slow.next;
        }
        
        if(last!=null){
            int temp = last.val;
            last.val = first.val;
            first.val = temp;
        }
        
        return head;
    }
}