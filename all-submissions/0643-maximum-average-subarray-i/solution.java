class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double sum = 0;
        double max = 0;
        int right = 0;
        
        for (right = 0; right < k; right++) {
            sum += nums[right];
        }
        max = sum/k;
        
        while(right < nums.length) {
            sum += nums[right];
            sum -= nums[left];
            left++; 
            right++;
            max = Math.max(max,sum/k);
        }
        return max;
    }
}
