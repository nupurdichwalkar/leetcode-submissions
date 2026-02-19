# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(node, currVal):
            if not node:
                return False
            if node.left is None and node.right is None:
                if currVal+node.val == targetSum:
                    return True
                else:
                    return False
            return dfs(node.left, currVal+node.val) or dfs(node.right, currVal+node.val)

        return dfs(root, 0)
