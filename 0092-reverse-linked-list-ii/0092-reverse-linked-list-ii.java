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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode a = null ,b= null , c = null , d = null;
        int pos = 1;
        ListNode temp = head;
        while(temp!=null){
            if(pos == left-1) a = temp;
            if(pos == left) b = temp;
            if(pos == right) c = temp;
            if(pos == right+1) d = temp;
            temp = temp.next;
            pos++;
        }
        if(a!=null) a.next = null;
        if(c!=null) c.next = null;
        
        reverse(b);
        if(a!=null) a.next = c;
        b.next = d;
//         this is for the testcase [3,5] changes to [5,3]
        if(a==null) return c;
        return head;
        
    }
}