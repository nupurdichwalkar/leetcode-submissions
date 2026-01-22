# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(node, currSum, targetSum):
            if not node:
                return False
            if node.left is None and node.right is None:
                if (currSum + node.val == targetSum):
                    return True
            currSum += node.val
            left = dfs(node.left, currSum, targetSum)
            right = dfs(node.right, currSum, targetSum)
            return left or right

        return dfs(root, 0 , targetSum)

