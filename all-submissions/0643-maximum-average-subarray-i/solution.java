class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i< k ; i++) {
            currSum += nums[i];
        }
        double currAvg = (double)currSum/k;
        double maxAvg = currAvg;
        for (int i=k; i<nums.length; i++ ){
            currSum  = currSum + nums[i] - nums[i-k];
            currAvg = (double)currSum/k;
            maxAvg = Math.max(currAvg, maxAvg);
        }
        return maxAvg;
        
    }
}
