# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        def bfs(root):
            if root is None:
                return 
            nonlocal res
            queue = deque([root])
            while queue:
                nodes_in_curr_level = len(queue)
                for i in range(nodes_in_curr_level):
                    node = queue.popleft()
                    if(i == nodes_in_curr_level - 1):
                        res.append(node.val)
                    if (node.left):
                        queue.append(node.left)
                    if(node.right):
                        queue.append(node.right)
        bfs(root)
        return res
