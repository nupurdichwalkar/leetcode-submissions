class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length;i++) {
            ans = Math.max(ans, dp(i, nums));
        }
        return ans;
        
    }

    public int dp(int i, int[] nums){
        int ans = 1;
        if(memo.containsKey(i)){
            return memo.get(i);
        }

        for(int j=0;j<i;j++){
            if(nums[j] < nums[i]){
                ans = Math.max(ans, dp(j, nums)+1);
            }
        }
        memo.put(i, ans);
        return memo.get(i);
    }
}
