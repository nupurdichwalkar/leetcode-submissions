/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
   TreeNode pre = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (pre!=null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
    }
    return true;
    }
}
