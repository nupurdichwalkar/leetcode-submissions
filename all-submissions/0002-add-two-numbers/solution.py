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
            new_node = ListNode(sum %10)
            temp.next = new_node
            temp = new_node
            l1 = l1.next
            l2 = l2.next
        while (l1 != None):
            sum = l1.val +carry
            carry = sum //10
            new_node = ListNode(sum %10)
            temp.next = new_node
            temp = new_node
            l1 = l1.next
        while (l2 != None):
            sum = l2.val +carry
            carry = sum //10
            new_node = ListNode(sum %10)
            temp.next = new_node
            temp = new_node
            l2 = l2.next
        if carry != 0:
            new_node = ListNode(carry)
            temp.next = new_node
            temp = new_node

        return dummy_head.next 
		
		

