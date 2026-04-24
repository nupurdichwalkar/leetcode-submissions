# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        queue = deque()
        if not root: return res
        node = root
        queue.append(node)
        while queue:
            ans = []
            nodesInCurrLevel = len(queue)
            for i in range(nodesInCurrLevel):
                curr_node = queue.popleft()
                ans.append(curr_node.val)
                if curr_node.left:
                    queue.append(curr_node.left)
                if curr_node.right:
                    queue.append(curr_node.right)
            res.append(ans)
        return res
