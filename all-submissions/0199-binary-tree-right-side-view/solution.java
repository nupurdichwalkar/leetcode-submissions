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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return answer;
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            TreeNode answerNode = queue.peek();
            if (answerNode != null) {
                answer.add(answerNode.val);
            }
            // do some logic here for the current level

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();


                if (node.right != null) {
                    queue.add(node.right);
                }

                // put the next level onto the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return answer;
    }
}
