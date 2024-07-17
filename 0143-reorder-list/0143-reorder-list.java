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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode Next = null;
        
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        
        return prev;
    }
    
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
//         for finding the left middle
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public void reorderList(ListNode head) {
//         finding the left middle
        ListNode leftMiddle = middle(head);
        ListNode head2 = leftMiddle.next;
        leftMiddle.next = null;
        
        head2 = reverse(head2);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null && head2!=null){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        
        if(head==null) temp.next = head2;
        if(head2==null) temp.next = head;
        head = dummy.next;
        
    }
}