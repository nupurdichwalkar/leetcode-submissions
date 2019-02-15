/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
        return true;
    }
    ListNode mid = findMiddle(head);
    ListNode second = mid.next;
    mid.next = null;
    second = reverse(second);
    while (head != null && second != null) {
        if (head.val != second.val) {
            return false;
        }
        head = head.next;
        second = second.next;
    }
    return true;
}
private ListNode findMiddle (ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
private ListNode reverse (ListNode head) {
    if (head == null || head.next == null) {
         return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
}
