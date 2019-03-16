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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder = BSThelper(root);
        int end = inorder.size()-1;
        int start = 0;
        while(start!=end)
        {
            if(inorder.get(start)+inorder.get(end)==k)
                return true;
            if(inorder.get(start)+inorder.get(end)>k)
                end--;
            else
                start++;
        }
        return false;
        
    }
    public List<Integer> BSThelper(TreeNode root)
    {
        List<Integer> a = new ArrayList<>();
        if(root == null)
            return a;
        a.addAll(BSThelper(root.left));
        a.add(root.val);
        a.addAll(BSThelper(root.right));
        return a;
    }
}
