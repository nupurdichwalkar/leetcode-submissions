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
    
    private int findMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
    }
    
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int answer = 0;
        int maxDepth = findMaxDepth(root);
        int currDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int nodesInCurrLevel = queue.size();
            answer = 0;
            for (int i=0; i< nodesInCurrLevel; i++) {
                TreeNode node = queue.remove();
                if (currDepth == maxDepth) {
                    answer += node.val;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            currDepth++;
        }
        return answer;
        
    }
}
