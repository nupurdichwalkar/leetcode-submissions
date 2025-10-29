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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2){
        if((node1 == null && node2!=null) || (node1 !=null && node2 == null)) {
            return false;
        }
        if(node1 == null && node2 == null) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(node1.val == node2.val) {
            left = isMirror(node1.left, node2.right);
            right = isMirror(node1.right, node2.left);
            return (left && right);
        }
        return false;
    }

    
}
