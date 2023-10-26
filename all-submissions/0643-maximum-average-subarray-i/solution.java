class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;
        int currSum = 0;
        
        for(int i=0; i<right; i++) {
            currSum +=nums[i];
        }
        double currAvg = (double) currSum / k;
        double maxAvg = currAvg;
        while(right < nums.length) {
            currSum = currSum - nums[left++] + nums[right++];
            currAvg = (double) currSum/k;
            maxAvg = Math.max(currAvg, maxAvg);
        }
        
        return maxAvg;
        
    }
}
