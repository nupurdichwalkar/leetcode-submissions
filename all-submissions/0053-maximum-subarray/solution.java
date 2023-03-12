class Solution {
    public int maxSubArray(int[] nums) {
        int curr_subArray = nums[0];
        int max_subArray = nums[0];

        for (int i =1 ;i< nums.length;i++){
            curr_subArray= Math.max(nums[i], curr_subArray + nums[i]);
            max_subArray = Math.max(curr_subArray, max_subArray);
        }
        return max_subArray;
    }
}
