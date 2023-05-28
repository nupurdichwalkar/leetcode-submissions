class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int minSubsequence = 0;
        for (int i=0 ;i<nums.length;i++){
            int minValue = nums[i];
            int maxValue = nums[i];
            while(maxValue-minValue <= k) {
                i++;
                if (i<nums.length) {
                    maxValue = nums[i];
                } 
                else {
                    minSubsequence++;
                    return minSubsequence;
                }
            }
            minSubsequence++;
            i--;
        }
        return minSubsequence;
    }
}
