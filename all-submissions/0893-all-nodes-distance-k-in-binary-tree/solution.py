# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        def createParentNode(node, parentNode):
            if node is None:
                return
            node.parent = parentNode
            createParentNode(node.left, node)
            createParentNode(node.right, node)

        createParentNode(root, None)
        ans = []
        visited = set()

        def dfs(node , k):
            if node is None or node in visited :
                return
            if k == 0:
                ans.append(node.val)
                return
            visited.add(node)
            dfs(node.left, k-1)
            dfs(node.right, k-1)
            dfs(node.parent, k-1)

        dfs(target, k)
        return ans
