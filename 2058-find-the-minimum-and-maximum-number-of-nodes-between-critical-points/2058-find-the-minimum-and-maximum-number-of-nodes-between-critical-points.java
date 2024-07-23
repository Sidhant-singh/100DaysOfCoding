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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode middle = head.next;
        ListNode right = head.next.next;
        int last = -1;
        int first = -1;
        int idx = 1;
        int minDistance = Integer.MAX_VALUE;
        int arr[] = {-1,-1};
        while(right!=null){
            if(middle.val<left.val && middle.val<right.val || middle.val>left.val && middle.val>right.val){
//                 we are only considering the first as for farther distance between two critical nodes resulting in max distance. 
                if(first==-1) first = idx;
                if(last!=-1){
                    int dis = idx - last;
                    minDistance = Math.min(minDistance,dis);
                }
                last = idx;
            }
            idx++;
            left = left.next;
            middle = middle.next;
            right = right.next;
            
        }
        if(last==first) return arr; //only 0 or 1 critical points
        int maxDistance = last-first;
        arr[0]= minDistance;
        arr[1] = maxDistance;
        return arr;
    }
}