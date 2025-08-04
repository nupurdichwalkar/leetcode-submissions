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

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        queue.add(root);
        while(!queue.isEmpty()){
            int nodesInCurrentLevel = queue.size();
            for(int i=0;i<nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                if(i== nodesInCurrentLevel-1) {
                    answer.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                } 
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return answer;
        
    }
}
