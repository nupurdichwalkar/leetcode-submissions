# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        k = head
        dummy = ListNode(0)
        dummy.next = head
        i = 1
        while(i != n and k is not None):
            k = k.next
            i +=1
        if (k is None): return head
        if (i==n and k.next is None):
            return  dummy.next.next
        curr = head
        prev = None
        while(k.next):
            k = k.next
            prev = curr
            curr = curr.next
        prev.next = curr.next
        return dummy.next

