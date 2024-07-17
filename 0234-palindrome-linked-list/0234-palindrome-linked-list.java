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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
//         creating a deep copy
        ListNode newHead = new ListNode(head.val);
        ListNode temp1 = head.next;
        ListNode temp2 = newHead;
        
        while(temp1!=null){
            ListNode newNode = new ListNode(temp1.val);
            temp2.next = newNode;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        
        newHead = reverse(newHead);
        
        temp1 = head;
        temp2 = newHead;
        while(temp1!=null){
            if(temp1.val!=temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
}