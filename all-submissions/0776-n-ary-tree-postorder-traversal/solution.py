"""
# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root: return []
        res = []
        
        def postorderrec(node: 'Node'):
            if not node:
                return
            if not node.children:
                return
            for child in node.children:
                postorderrec(child)
                res.append(child.val)
        
        postorderrec(root)
        res.append(root.val)
        return res
        
        
