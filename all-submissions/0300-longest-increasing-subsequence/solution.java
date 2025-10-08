class Solution {


    public int lengthOfLISRecur(int[] nums, int index, int prevIndex, int[][] dp) {
        if(index >= nums.length) return 0;
        if(dp[index][prevIndex+1] != 0) return dp[index][prevIndex+1];
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) {
           dp[index][prevIndex+1] =  Math.max(lengthOfLISRecur(nums, index+1, index, dp) + 1, lengthOfLISRecur(nums, index+1, prevIndex,  dp));
        } else {
            dp[index][prevIndex+1] = lengthOfLISRecur(nums, index+1, prevIndex, dp);
        }
        return dp[index][prevIndex+1];
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        return lengthOfLISRecur(nums, 0, -1, dp);
    }
}
