# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(0)
        temp = dummy_head
        carry = 0
        sum =0

        while (l1 != None and l2 != None):
            sum = l1.val + l2.val + carry
            carry = sum //10
            temp.next =  ListNode(sum %10)
            temp = temp.next
            l1 = l1.next
            l2 = l2.next
        while (l1 != None):
            sum = l1.val +carry
            carry = sum //10
            temp.next =  ListNode(sum %10)
            temp = temp.next
            l1 = l1.next
        while (l2 != None):
            sum = l2.val +carry
            carry = sum //10
            temp.next =  ListNode(sum %10)
            temp = temp.next
            l2 = l2.next
        if carry != 0:
            temp.next =  ListNode(carry)
            temp = temp.next

        return dummy_head.next 
		
		

