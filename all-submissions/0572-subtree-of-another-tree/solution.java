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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return getNode(s,t);
    }
    public boolean checker(TreeNode a, TreeNode b)  
    { 
        if (a == null && b == null) 
            return true;
        if (a == null || b == null) 
            return false;
        return a.val == b.val && checker(a.left, b.left) && checker(a.right, b.right); 
    }
    public boolean getNode(TreeNode s, TreeNode t)
    {
        return s!=null && (checker(s,t) || getNode(s.left,t) || getNode(s.right,t));
    }
}
