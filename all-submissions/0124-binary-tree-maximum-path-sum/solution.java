/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxFromSubtree(root);
        return max;
    }

    public int getMaxFromSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftGain = Math.max(getMaxFromSubtree(root.left),0);
        int rightGain = Math.max(getMaxFromSubtree(root.right), 0);

        max = Math.max(max, leftGain+rightGain+root.val);
        // return the max sum for a path starting at the root of subtree
        return Math.max(leftGain + root.val, rightGain + root.val);
    }
}
