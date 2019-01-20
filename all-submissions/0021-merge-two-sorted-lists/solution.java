/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr_result= new ListNode(-1);
        ListNode result = curr_result;
        while((l1 !=null) && (l2 !=null))
        {
            
            if(l1.val <= l2.val )
            {
                curr_result.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr_result.next = l2;
                l2 = l2.next;
            }
            curr_result = curr_result.next;
                
        }
            if(l1==null)
            {
               curr_result.next = l2;
            }
            else if(l2==null)
            {
               curr_result.next = l1;
            }
        return result.next;
    }
}
