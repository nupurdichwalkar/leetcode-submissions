class Solution {
    public int minStartValue(int[] nums) {
        
        int[] prefix = new int[nums.length];
        
        prefix[0] = nums[0];
        
        int minStartValue = Math.max(1, -1 * nums[0] + 1);
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
            if(prefix[i] < 0) {
                minStartValue = Math.max(minStartValue, -1 * prefix[i] + 1);
            }
        }
        
        return minStartValue;
        
    }
}
