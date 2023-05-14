class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        boolean isAllPositive = false;
        while(!isAllPositive) {
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = nums[0] + startValue;
            if (prefixSum[0] < 1) {
                startValue++;
                continue;
            }
            int i=1;
            while(i<nums.length) {
                prefixSum[i] = nums[i] + prefixSum[i-1];
                if(prefixSum[i] < 1) {
                    startValue++;
                    break;
                }
                i++;
            }
            if (i == nums.length){
                isAllPositive = true;
            }
                
        }
        return startValue;
    }
}
