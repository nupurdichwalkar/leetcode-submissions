class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZeros = 0;
        int left =0;
        int right =0;
        int maxOnes = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                countZeros++;
            }
            if(countZeros > k) {
                while(countZeros > k && left < nums.length && left <= right){
                    if(nums[left] == 0) {
                        countZeros--;
                    } 
                    left++;
                }
            }
            maxOnes = Math.max(maxOnes, right-left+1);
            right++;
        }
        return maxOnes;
    }
}
