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
    public int lengthOfList(ListNode head){
        int n =0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        return n;
        
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = lengthOfList(head);
        int size = len/k; //n/k+1
        int extra = len%k;
        ListNode []arr = new ListNode[k];
        int idx = 0;
        ListNode temp = head;
        len = 1;
        while(temp!=null){
            int s = size;
            if(extra>0) s++;
            if(len==1) arr[idx++] = temp;;
            if(len==s){
                ListNode a = temp.next;
                temp.next = null;
                temp = a;
                len = 1;
                extra--;
                
            }
            else{
                len++;
                temp = temp.next;
            }
        }
        return arr;
    }
}