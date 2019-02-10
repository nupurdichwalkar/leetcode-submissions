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
    public ListNode detectCycle(ListNode head) {
        
        ListNode p1=head;
        ListNode p2=head;
        
        while(p1!=null && p1.next!=null)
        {
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1==p2)
            {
                ListNode newp2 = head;
                while(p2!=newp2)
                {
                    p2 =p2.next;
                    newp2 = newp2.next;
                }
                return p2;
            }
            
        }
        return null;
}
}
