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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int val1 = 0,val2 =0;
//          we have done this for unequal length of LL and we have add 0 if the l1 or l2 reaches null.
            if(l1!=null) val1 = l1.val;
            if(l2!=null) val2 = l2.val;
            int sum = carry + val1 + val2;
            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;
            temp = temp.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            
            if(sum>9){
                carry = 1;
            }
            else{
                carry = 0;
            }
        }
//         if after the loop carry remains 1 it means we have to make a node of it and add it to the end of the LL. 
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            temp.next = newNode;
            temp = temp.next;
        }
        
        return dummy.next;
    }
}