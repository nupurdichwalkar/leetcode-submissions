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

    int count = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null ) return 0;
        int maxVal = root.val;
        goodNodes(root.left, maxVal);
        goodNodes(root.right, maxVal);
        return count+1;
    }

    private void goodNodes(TreeNode root, int maxVal) {
        if(root == null) return;
        if (root.val >= maxVal) {
            maxVal = root.val;
            count++;
        } 
        goodNodes(root.left, maxVal); 
        goodNodes(root.right, maxVal);
    }
}
