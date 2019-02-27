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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        TreeNode root = buildTree(nums,left,right);
        return root;
    }
    public TreeNode buildTree(int[] nums, int left, int right)
    {
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if(left > right)
            return null;
        else
        {
            node.left = buildTree(nums,left,mid-1);
            node.right = buildTree(nums,mid+1,right);
        }
        return node;
    }
}
