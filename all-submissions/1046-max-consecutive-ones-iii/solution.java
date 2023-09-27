class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int numberOfZeros=0;
        int cur=0, ans=0;
        for(int right=0; right < nums.length; right++) {
            if(nums[right]==0) {
                numberOfZeros++;
            }
            while(numberOfZeros>k) {
                cur--;
                if(nums[left]==0) {
                    numberOfZeros--;
                }
                left++;
            }
            cur++;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
