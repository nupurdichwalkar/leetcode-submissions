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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode kthNode = head;
        ListNode prev = null;
        int i = 0;
        while(i<k) {
            prev = kthNode;
            fast = fast.next;
            kthNode = kthNode.next;
            i++;
        }
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        int temp = slow.val;
        slow.val = prev.val;
        prev.val = temp;

        return head;

    }
}
