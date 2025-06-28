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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public int getDecimalValue(ListNode head) {
        if(head == null) return -1;
        if(head.next == null) return head.val;
        ListNode node = reverseList(head);
        int i=0;
        int answer =0;
        while(node != null) {
            answer += Math.pow(2, i)*node.val;
            node = node.next;
            i++;
        }
        return answer;
    }
}
