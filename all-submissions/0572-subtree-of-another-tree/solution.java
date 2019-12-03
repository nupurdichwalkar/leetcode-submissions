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
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        
        boolean a = util(s, t);
        boolean b = isSubtree(s.left, t);
        boolean c = isSubtree(s.right, t);
        return a || b || c;
    }
    
    private boolean util(TreeNode s, TreeNode t){
        // both absent
        if(s == null && t == null){
            return true;
        }
        // one of them is absent
        if(s == null || t == null){
            return false;
        }
        return s.val == t.val && util(s.left, t.left) && util(s.right, t.right);
    }

}
