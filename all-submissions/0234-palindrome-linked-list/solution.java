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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        List<Integer> arr = new ArrayList<>();
        while(curr!=null){
            arr.add(curr.val);
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        int i = 0;
        while (prev != null) { 
            System.out.println(prev.val + " " + i + " " + arr.get(i));
            if(prev.val != arr.get(i)){ return false;}
            prev = prev.next;
            i++;
        }
        return true;
        
    }
}
