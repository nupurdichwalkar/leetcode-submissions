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
    List<Integer> nodesList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        dfs(root);
        for (int i = 0; i< nodesList.size()-1; i++) {
            if (nodesList.get(i) >= nodesList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root) {
        if (root == null) 
            return;
        dfs(root.left);
        nodesList.add(root.val);
        dfs(root.right);
    }
}
