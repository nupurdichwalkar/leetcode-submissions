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
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) return root.val;
        int closest = root.val;
        int currVal = root.val;
        while(root != null) {
            currVal = root.val;
            closest = Math.abs(currVal-target) < Math.abs(closest-target) ? currVal : closest;
            closest = Math.abs(currVal-target) == Math.abs(closest-target) && currVal < closest ? currVal : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
        
        
    }
}
