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
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
      traverse(root,L,R);
        return sum;
    }
    public void traverse(TreeNode root, int L, int R){
          if(root==null)
            return;
        if(root.val >=L && root.val<=R){
            sum += root.val; 
        }
        if(root.val<R)
        traverse(root.right,L,R);
        if(root.val>L)
        traverse(root.left,L,R);
    }
}
