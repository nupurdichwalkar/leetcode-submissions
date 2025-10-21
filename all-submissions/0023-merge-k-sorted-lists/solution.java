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
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator;
        comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(comparator);
        for(ListNode list: lists) {
            if(list != null)
                priorityQueue.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!priorityQueue.isEmpty()){
            curr.next = priorityQueue.poll();
            curr = curr.next;
            ListNode next = curr.next;
            if(next!=null){
                priorityQueue.add(next);
            }
        }
        return head.next;

        

    }
}
