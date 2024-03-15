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
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
//          placing the pointer in the middle node
        }
        
        ListNode temp = reverse(slow.next); //placing the pointer to the right of middle node
        slow.next = temp;
        
        ListNode p1 = head;
        ListNode p2 = slow.next;
        
        while(p1!=null && p2!=null){
            int res = p1.val + p2.val;
            max = Math.max(res,max);
            p2 = p2.next;
            p1 = p1.next;
        }
        return max;
    }
}
