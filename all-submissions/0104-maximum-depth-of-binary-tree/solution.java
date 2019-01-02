import java.lang.Math;
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
    public int maxDepth(TreeNode root) {                                                              
        if (root==null)
            return 0;
        else
        {
        TreeNode current = root;
        if(current.left == null && current.right == null)
             return 1;
        else 
            return 1 + Math.max(maxDepth(current.left),maxDepth(current.right));
        }
    }
}
