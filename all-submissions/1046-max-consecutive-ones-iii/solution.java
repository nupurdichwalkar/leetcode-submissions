class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int currZeros = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                currZeros++;
            }
            while(currZeros >k){
                if(nums[left] ==0){
                    currZeros--;
                }
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
        
    }
}
