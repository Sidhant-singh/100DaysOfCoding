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
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        
        ListNode a = new ListNode(-1); // dummy node for the "less than x" list
        ListNode b = new ListNode(-1); // dummy node for the "greater than or equal to x" list
        ListNode tempA = a; // pointer to the end of the "less than x" list
        ListNode tempB = b; // pointer to the end of the "greater than or equal to x" list
        ListNode temp = head; // pointer to iterate through the original list
        
        while(temp != null) {
            if(temp.val < x) {
                tempA.next = temp;
                tempA = tempA.next;
            } else {
                tempB.next = temp;
                tempB = tempB.next;
            }
            temp = temp.next;
        }
        
        tempB.next = null; // ensure the end of the "greater than or equal to x" list is null
        tempA.next = b.next; // link the end of the "less than x" list to the beginning of the "greater than or equal to x" list
        
        return a.next; // return the head of the "less than x" list, which is the next node after the dummy
    }
}
