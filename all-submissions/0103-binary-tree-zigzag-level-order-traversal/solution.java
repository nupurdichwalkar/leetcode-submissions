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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 1;

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            // do some logic here for the current level
            LinkedList<Integer> eachLevelList = new LinkedList<>();
            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                if (currLevel % 2 == 0) {
                    eachLevelList.addFirst(node.val);
                } else {
                    eachLevelList.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            answer.add(eachLevelList);
            currLevel++;
        }
        return answer;
        
    }
}
