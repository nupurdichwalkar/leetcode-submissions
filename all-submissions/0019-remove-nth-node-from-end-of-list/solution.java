/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(n>1)
        {
            p2 = p2.next;
            n--;
        }
        while(p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next;
            prev = prev.next;
        }
        prev.next = p1.next;
        return dummy.next;
    }
}
