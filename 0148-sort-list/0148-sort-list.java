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
    public ListNode merge(ListNode list1, ListNode list2) {
//         we are making dummy node as it handles different cases of list1 or list2 being null
        ListNode dummy = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode t = dummy;
        
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                t.next = temp1;
                temp1 = temp1.next;
            }
            else{
                t.next = temp2;
                temp2 = temp2.next;
            }
            t=t.next;
        }
        
        if(temp1==null) t.next = temp2;
        else t.next = temp1;
        
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode firstHalf = head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        
        ListNode ans = merge(firstHalf,secondHalf);
        
        return ans;
        
    }
}