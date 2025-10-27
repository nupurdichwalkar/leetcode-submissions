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
        if(head == null || k ==0) return head;
        if (head.next == null) return head;
        ListNode curr = head;
        int length =1;
        while(curr.next != null){
            curr=curr.next;
            length++;
        }
        curr.next = head;
        k = k%length;
        k = length-k;
        while(k>0){
            curr = curr.next;
            k--;
        }
        head = curr.next;
        curr.next=null;
        return head;
        
    }
}
