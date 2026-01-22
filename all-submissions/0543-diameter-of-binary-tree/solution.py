# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0
        def dfs(node):
            if node is None:
                return -1
            left = dfs(node.left)
            right = dfs(node.right)
            nonlocal diameter
            diameter = max(diameter, left+right+2)
            return max(left, right) + 1
        dfs(root)
        return diameter
