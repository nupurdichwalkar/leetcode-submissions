class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        for(int i = 0; i < k; i++) {
            sum  += nums[i];
        }
        double maxAvg = (sum * 1.0) /k;
        for(int right = k; right < nums.length; right++) {
            sum += (nums[right] - nums[left++]);
            maxAvg = Math.max(maxAvg, sum*1.0/k); 
        }
        return maxAvg;
    }
}
