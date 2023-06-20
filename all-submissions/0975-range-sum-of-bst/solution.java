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

    List<Integer> sortedList = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        sortedList.add(root.val);
        dfs(root.right);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root);
        int sum =0;
        for(int value: sortedList) {
            if (value >= low && value <= high) {
                sum += value;
            }
        }
        return sum;

    }
}
