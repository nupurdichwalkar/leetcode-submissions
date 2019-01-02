/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*; 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> a = new ArrayList<Integer>();
        if(root==null)
            return a;
      if(root.left!=null)
      {
          a.addAll( inorderTraversal(root.left));
      }
        a.add(root.val);
      if(root.right!=null)
      {
          a.addAll(inorderTraversal(root.right));
      }
          return a;
    }
}
