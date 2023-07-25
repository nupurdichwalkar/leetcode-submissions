class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minSubArray = nums.length+1;
        int currSum = 0;
        while(right < nums.length) {
            currSum += nums[right];
            while(currSum >= target ) {
                minSubArray = Math.min(right-left+1, minSubArray);
                currSum -= nums[left++];
            }
            right++;
        }
        return minSubArray > nums.length ? 0 : minSubArray;
        
    }
}
