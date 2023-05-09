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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null){
            return null;
        }
        if (head.next == null ){
            return head;
        }
        ListNode ptr = head;
        ListNode curr = head.next;
        while(curr != null){
            if (curr.val == ptr.val) {
                curr = curr.next;
            } else {
                ptr.next = curr;
                ptr = curr;
                curr = curr.next;
            }
        }
        ptr.next = curr;
        return head;
        
    }
}
