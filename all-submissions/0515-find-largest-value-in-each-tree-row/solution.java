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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int nodesinCurrLevel = queue.size();
            int maxInCurrLevel = Integer.MIN_VALUE;
            for (int i=0; i<nodesinCurrLevel; i++) {
                TreeNode node = queue.remove();
                maxInCurrLevel = Math.max(maxInCurrLevel, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            answer.add(maxInCurrLevel);
        }
        return answer;
    }
}
