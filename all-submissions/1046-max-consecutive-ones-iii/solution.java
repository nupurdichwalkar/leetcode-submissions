class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength=0;
        int countZero = 0;
        int left =0;
        for(int right =0; right<nums.length; right++) {
            if(nums[right] == 0) {
                countZero++;
            }
            if(countZero > k) {
                while(left<=right && countZero > k) {
                    if(nums[left] == 0) {
                        countZero--;
                    }
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
