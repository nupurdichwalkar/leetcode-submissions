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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.max(leftDepth +1, rightDepth+1);
    }

    public int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left)+1, dfs(node.right)+1);

    }
}
