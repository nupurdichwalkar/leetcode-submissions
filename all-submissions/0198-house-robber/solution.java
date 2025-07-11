class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
       return dp(nums.length-1,nums);    
    }

    public int dp(int index, int[] nums){
        if(index == 0) return nums[0];
        if(index == 1) return Math.max(nums[0], nums[1]);

        if(memo.containsKey(index)){
            return memo.get(index);
        }
        memo.put(index, Math.max(dp(index-1, nums), dp(index-2, nums) + nums[index]));
        return memo.get(index);
    }
}
