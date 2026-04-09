# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: 
            return None
        def merge2Lists(listA, listB):
            dummyHead = ListNode()
            curr = dummyHead
            while listA and listB:
                valA = listA.val
                valB = listB.val
                if valA<=valB:
                    curr.next = listA
                    listA = listA.next
                elif valA > valB:
                    curr.next = listB
                    listB = listB.next
                curr = curr.next
            curr.next = listA if not listB else listB
            return dummyHead.next

        
        while(len(lists)) > 1:
            temp = []
            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if i + 1 < len(lists) else None
                temp.append(merge2Lists(l1, l2))  
            lists = temp
        return lists[0]
