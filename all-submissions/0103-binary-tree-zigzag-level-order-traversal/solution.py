# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        isReverse = False
        if root is None:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while(queue):
            node_len = len(queue)
            res = []
            if isReverse:
                for i in range(node_len-1, -1, -1):
                    res.append(queue[i].val)
            else:
                for i in range(0, node_len):
                    res.append(queue[i].val)
            result.append(res)
            for i in range(node_len):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            isReverse = not isReverse
        return result


