class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        boolean allPositive = false;
        
        while(!allPositive) {
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = nums[0] + startValue;
            if (prefixSum[0] < 1) {
                startValue++;
                continue;
            }
            int i=1;
            while(i<nums.length) {
                prefixSum[i] = prefixSum[i-1] + nums[i] ;
                if(prefixSum[i] < 1){
                    startValue++;
                    break;
                }
                i++;
            }
            if(i == nums.length){
                allPositive = true;
            }
        }
        
        return startValue;
        
    }
}
