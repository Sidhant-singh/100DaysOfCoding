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
        // If the list is empty or has only one node, return the head
        if (head == null || head.next == null)
            return head;

        // Calculate the length of the list and find the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Calculate the actual rotation amount
        k = k % length;

        // If k is 0, no rotation needed, return the head
        if (k == 0)
            return head;

        // Find the new tail node
        int newTailPosition = length - k;
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // Adjust pointers to rotate the list
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}