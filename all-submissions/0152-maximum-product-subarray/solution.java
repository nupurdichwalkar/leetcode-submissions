class Solution {
    public int maxProduct(int[] nums) {
        int prevmax = nums[0];
        int prevmin = nums[0];
        int ans = nums[0];
        for(int i = 1; i<nums.length;i++)
        {
            int temp = prevmax;
            prevmax = Math.max(prevmax*nums[i],Math.max(prevmin*nums[i],nums[i]));
            prevmin = Math.min(temp*nums[i],Math.min(prevmin*nums[i],nums[i]));
            ans = Math.max(ans,prevmax);
        }
        return ans;
    }
}
