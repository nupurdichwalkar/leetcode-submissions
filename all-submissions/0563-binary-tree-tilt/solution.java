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
    int tilt;
    public int findTilt(TreeNode root) {
        getTilt(root);
         return tilt;
    }
    public int getTilt(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = getTilt(root.left);
        int right = getTilt(root.right);
        tilt += Math.abs(left-right);
        return left + right + root.val;
    }
}
