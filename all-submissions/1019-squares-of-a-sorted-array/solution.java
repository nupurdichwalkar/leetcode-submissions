class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];
        int ansPointer = result.length - 1;
        int i = 0;
        int j = nums.length-1;
        
        while(i<j) {
            if(nums[i]*nums[i]<nums[j]*nums[j]) {
                result[ansPointer] = nums[j]*nums[j];
                j--;
            } else {
                result[ansPointer] = nums[i]*nums[i];
                i++;
            }
            ansPointer--;
        }
        if(i==j) {
            result[ansPointer] = nums[i]*nums[i];
        }
       return result;
    }
}
