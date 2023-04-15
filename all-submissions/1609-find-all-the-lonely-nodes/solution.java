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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) return results;  
        getLonelyNodes(root, false, results);
        return results;
    }

    private void getLonelyNodes(TreeNode root, boolean isLonely, List<Integer> results) {
         if (root == null) return;

        if (isLonely) {
            results.add(root.val);
        }

        if (root.left == null) {
            getLonelyNodes(root.right, true, results);
        } else {
            getLonelyNodes(root.right, false, results);
        }
        if (root.right == null){
            getLonelyNodes(root.left, true, results);
        } else {
            getLonelyNodes(root.left, false, results);
        }
    }




}
