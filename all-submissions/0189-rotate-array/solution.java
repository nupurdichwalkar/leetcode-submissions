class Solution {
    public void rotate(int[] nums, int k) {

        int[] ans = new int[nums.length];
        if (k%nums.length == 0) return;
        k = k%nums.length;
        int startIndex = nums.length - k;
        int j=0;
        for(int i=startIndex;i<nums.length;i++) {
            ans[j++] = nums[i];
        }
        for(int i=0; i<startIndex; i++){
            ans[j++] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = ans[i];
        }
        return;
        
    }
}
