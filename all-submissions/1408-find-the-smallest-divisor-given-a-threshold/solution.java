class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = findMax(nums);
        int right = 1;
        while(left >= right) {
            int mid = (left + right)/2;
            int sum = getDivisorsSum(nums, mid);
            if (sum > threshold) {
                right = mid+1;
            }
            else {
                left = mid-1;
            }
        }
        return left+1;
    }


    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getDivisorsSum(int[] nums, int divisor){
        int sum = 0;
        for (int num: nums){
            sum += (int)Math.ceil((double)num/divisor);
        }
        return sum;
    }
}
