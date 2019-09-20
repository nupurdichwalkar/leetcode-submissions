/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode temp = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        head=prev;
        return head;
    }
}
