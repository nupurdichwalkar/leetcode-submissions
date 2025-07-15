class Solution {
    public boolean canJump(int[] nums) {
 int n = nums.length;
        // memo[i] = 1 means true, 0 means false, -1 means not calculated
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        return canReachFrom(0, nums, memo);
    }

    private boolean canReachFrom(int index, int[] nums, int[] memo) {
        // If we've reached or passed the last index
        if (index >= nums.length - 1) return true;

        // If already computed
        if (memo[index] != -1) {
            return memo[index] == 1;
        }

        int furthestJump = Math.min(index + nums[index], nums.length - 1);
        for (int nextIndex = index + 1; nextIndex <= furthestJump; nextIndex++) {
            if (canReachFrom(nextIndex, nums, memo)) {
                memo[index] = 1;
                return true;
            }
        }

        memo[index] = 0;
        return false;
    }
}
