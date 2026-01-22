# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        res = []
        queue = deque()
        queue.append(root)
        while queue:
            nodes_in_curr_level = len(queue)
            currMax = float("-inf")
            for _ in range(nodes_in_curr_level):
                node = queue.popleft()
                currMax = max(currMax, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(currMax)
        return res
