# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        # def maxDepth(node):
        #     if node is None:
        #         return 0
        #     return max(maxDepth(node.left), maxDepth(node.right)) +1
        # max_level = maxDepth(root)
        queue = deque()
        queue.append(root)
        ans = 0
        while queue:
            nodes_len = len(queue)
            ans = 0
            for _ in range (nodes_len):
                node = queue.popleft()
                ans += node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return ans

