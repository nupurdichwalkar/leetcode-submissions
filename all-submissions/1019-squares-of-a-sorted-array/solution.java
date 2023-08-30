class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0,right = 0,i=0;
        int[] result = new int[nums.length];
        
        if (nums.length == 1) {
            result[0] = nums[0] * nums[0];
            return result;
        }
        
        while(i < nums.length && nums[i++] < 0) {
            right++;
        }
        
        if (right > 0) {
            left = right - 1;    
        }
        
        int j = 0;
        while(left >= 0 && right < nums.length && left!=right) {
            if((nums[left] * nums[left]) <= (nums[right] * nums[right])) {
                result[j++] = nums[left] * nums[left];
                left--;
            } else {
                result[j++] = nums[right] * nums[right];
                right++;
            }    
        }
        while (left >= 0 && nums[left] < 0) {
            result[j++] = nums[left] * nums[left];
            left--;
        }
        while (right < nums.length) {
            System.out.println("right=" + right + ",j=" + j);
            result[j++] = nums[right] * nums[right];
            right++;
        } 
        return result;
        
    }
}
