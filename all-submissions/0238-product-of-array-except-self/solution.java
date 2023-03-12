class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i= 1; i< length; i++) {
            answer[i] = nums[i-1] * answer[i-1];
        }
        int product = nums[length-1];
        for (int i = length-2; i >= 0 ;i--){
            answer[i] = product * answer[i];
            product = product * nums[i];
        }

        return answer;
    }
}
