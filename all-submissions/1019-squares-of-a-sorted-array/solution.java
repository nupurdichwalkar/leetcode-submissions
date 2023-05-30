class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int ansPointer = nums.length - 1;
        
        while (i<j) {
            if(nums[i]*nums[i] > nums[j]*nums[j]) {
                ans[ansPointer] = nums[i]*nums[i];
                i++;
            } else {
                ans[ansPointer] = nums[j]*nums[j];
                j--;
            }
            ansPointer--;
        }
        if(i==j) {
            ans[ansPointer] = nums[i]*nums[i];
        }
        return ans;
    }   
}
