class Solution {
    public int maxSubArray(int[] nums) {

        int left = 0;
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int right=0;right<nums.length; right++) {
            currSum += nums[right];
            if(currSum < nums[right]) {
                currSum = nums[right];
                left = right;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
        // int curr_subArray = nums[0];
        // int max_subArray = nums[0];

        // for (int i =1 ;i< nums.length;i++){
        //     curr_subArray= Math.max(nums[i], curr_subArray + nums[i]);
        //     max_subArray = Math.max(curr_subArray, max_subArray);
        // }
        // return max_subArray;
    }
}
