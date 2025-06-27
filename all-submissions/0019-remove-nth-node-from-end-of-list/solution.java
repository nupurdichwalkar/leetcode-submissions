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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if(head.next==null && n==1) return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        int i=1;
        while(i <= n) {
            fast = fast.next;
            i++;
        }
        while(fast != null) {
            prev=slow;
            slow = slow.next;
            fast=fast.next;
        }
        if (slow == head) {
            head = head.next;
            return head;
        }
        prev.next = slow.next;
        return head;
    }
}
