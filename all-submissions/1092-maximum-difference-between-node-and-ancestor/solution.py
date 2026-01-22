# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        def dfs_helper(node, curr_max, curr_min):
            if node is None:
                return curr_max - curr_min
            curr_max = max(node.val, curr_max)
            curr_min = min(node.val, curr_min)
                    
            left = dfs_helper(node.left, curr_max, curr_min)
            right = dfs_helper(node.right, curr_max, curr_min)
            return max(left, right)
        return dfs_helper(root, root.val, root.val)
