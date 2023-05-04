class Solution {
    public double findMaxAverage(int[] nums, int k) {
       
        int left = 0;
        int right = k-1;
        int sum = 0;
        for (int i=left; i<=right; i++) {
            sum += nums[i];
        }
        double answer = (double)sum/k;
        while (right < nums.length-1) {
            answer = Math.max(answer, (double)sum/k);
            sum = sum - nums[left++] + nums[++right];
        }
        return Math.max(answer, (double)sum/k);
    }
}
