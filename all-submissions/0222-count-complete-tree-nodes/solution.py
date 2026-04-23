# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0

        def countNodesCurr(node, currCount):
            if node == None:
                return 0
            return countNodesCurr(node.left, currCount) + countNodesCurr(node.right, currCount) + 1
        
        return countNodesCurr(root, 1)
