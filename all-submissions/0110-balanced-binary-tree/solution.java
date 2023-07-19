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

    public int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight+1;
        // return getHeight(node.left) + getHeight(node.right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight-rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
        
    }
}
