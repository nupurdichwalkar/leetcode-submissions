/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) 
            return false;
        ListNode p1=head.next;
        ListNode p2=head;
        
        while(p1!=p2)
        {
            if(p1==null||p1.next==null)
                return false;
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return true;
        
    }
}
