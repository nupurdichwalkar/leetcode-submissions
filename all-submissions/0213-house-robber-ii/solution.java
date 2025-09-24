class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max1 = rob_simple(nums, 0 , nums.length-1);
        int max2 = rob_simple(nums, 1, nums.length);

        return Math.max(max1, max2);
        

    }

    private int rob_simple(int[] nums, int start, int end) {
        int[] dp = new int[end-start];
        dp[0] = nums[start];  //1
        dp[1] = Math.max(nums[start], nums[start+1]);  //1,2

        for(int i=start+2; i<end;i++) {
            dp[i-start] = Math.max(dp[i-start-1], dp[i-start-2] + nums[i]);
        }
        return dp[dp.length-1];
    }
}
