# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0
        res = 0
        max_val_so_far = root.val
        def dfs(node, max_val_so_far):
            if node is None:
                return 
            nonlocal res
            if node.val >= max_val_so_far:
                res += 1
                max_val_so_far = node.val
            dfs(node.left, max_val_so_far)
            dfs(node.right, max_val_so_far)
        dfs(root, max_val_so_far)
        return res
