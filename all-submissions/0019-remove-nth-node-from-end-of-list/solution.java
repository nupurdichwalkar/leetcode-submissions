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
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr = prev;
        ListNode runner = prev;
        for (int i =1 ; i <= n+1; i++){
            runner = runner.next;
        }
        while (runner!= null) {
            curr = curr.next;
            runner = runner.next;
        }

        curr.next = curr.next.next;
        return prev.next;
    }
}
