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
    int maxValue = 0;
    int minValue = 0;

    public int helper(TreeNode root, int maxValue, int minValue){
        if (root == null) return maxValue-minValue;
        maxValue = Math.max(root.val, maxValue);
        minValue = Math.min(root.val, minValue);
        int left = helper(root.left, maxValue, minValue);
        int right = helper(root.right, maxValue, minValue);
        return Math.max(left, right);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        maxValue = root.val;
        minValue = root.val;
        return helper(root, maxValue, minValue);
                
    }
}
