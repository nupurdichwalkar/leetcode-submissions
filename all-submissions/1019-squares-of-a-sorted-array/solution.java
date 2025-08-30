class Solution {
    public int[] sortedSquares(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int[] result = new int[nums.length];
        int resultIndex =nums.length-1;
        while(start<end){
            if(nums[start]* nums[start] < nums[end]*nums[end]) {
                result[resultIndex--] = nums[end]* nums[end];
                end--;
            } else {
                result[resultIndex--] = nums[start]* nums[start];
               start++;
            }
        }
        if(start==end){
            result[resultIndex] = nums[start]*nums[start];
        }
        return result;
    }
}
