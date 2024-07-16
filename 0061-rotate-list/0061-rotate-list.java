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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
//         finding the length
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        ListNode dummy = head;
        ListNode slow = head;
        ListNode fast = head;
        k=k%len;
        if(k==0) return head;
        for(int i=1;i<=k;i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newNode = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newNode;
        
        
    }
}