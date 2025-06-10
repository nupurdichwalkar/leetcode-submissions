class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int smallestSum = prefixSum[0];
        for (int i=1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            smallestSum = Math.min(smallestSum, prefixSum[i]);
        }

        if (smallestSum < 0) {
            return smallestSum * -1 +1;
        }
        return 1;

    }
}
