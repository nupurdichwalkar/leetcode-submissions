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

    ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr=head;
        while(curr!= null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseList(slow);
        int max = 0;
        while(head!=null && head2!=null) {
            max = Math.max(max, head.val + head2.val);
            head=head.next;
            head2 = head2.next;
        }
        return max;
    }
}
