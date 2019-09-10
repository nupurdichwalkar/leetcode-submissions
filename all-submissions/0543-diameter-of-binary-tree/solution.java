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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    
    public int maxDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }
    
}
