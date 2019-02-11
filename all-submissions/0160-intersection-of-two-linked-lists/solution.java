/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        ListNode p1;
        ListNode p2;
        int countA = 0;
        int countB = 0;
        while(currA!=null)
        {
            countA++;
            currA = currA.next;
        }
        while(currB!=null)
        {
            countB++;
            currB = currB.next;
        }
        if(countA > countB)
        {
            int index = countA - countB;
            p1 = getNode(headA,index);
            p2 = headB;
        }
        else
        {
            int index = countB - countA;
            p1 = getNode(headB, index);
            p2 = headA;
        }
        while(p1!=p2)
        {
            if(p1.next == null || p2.next == null)
                return null;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    public ListNode getNode(ListNode head, int index)
    {
        ListNode cur = head;
        for(int i =0; i<index && cur != null; i++)
        {
            cur = cur.next;
        }
        return cur;
    }
}
