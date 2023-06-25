class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minSubArray = Integer.MAX_VALUE;
        int currSum = 0;
        while(right < nums.length) {
            currSum += nums[right];
            while(currSum >= target ) {
                minSubArray = Math.min(right-left+1, minSubArray);
                currSum -= nums[left++];
            }
            right++;
        }
        return minSubArray == Integer.MAX_VALUE ? 0 : minSubArray;
        
    }
}
