/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
     Stack<TreeNode> stack = new Stack<>();
     int first = Integer.MAX_VALUE;
     int second = Integer.MAX_VALUE;
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         if(root.val < first)
         {
             second = first;
             first = root.val;
         }
         else if (root.val < second && root.val != first) 
                second = root.val;
         root = root.right;
     }
        if(first==second || second == Integer.MAX_VALUE )
            return -1;
        return second;
    }
}
