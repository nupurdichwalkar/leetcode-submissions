class Solution {
    public int waysToSplitArray(int[] nums) {
        int answer = 0;
        long prefix[] = new long[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int j=0;j<nums.length-1; j++){
            long sumLeft = prefix[j];
            long sumRight = prefix[nums.length-1] - prefix[j];
            if (sumLeft >=sumRight) {
                answer++;
            }
        }
        return answer;
    }
}
