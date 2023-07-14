class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];        
        int firstPositiveIndex = len-1;
        for (int i =0; i<len; i++) {
            if(nums[i] >=0) {
                firstPositiveIndex = i;
                break;
            }
        }
        int j = firstPositiveIndex;
        int k = firstPositiveIndex-1;
        int i=0;
        while(j<len && k>-1) {
            int sq1 = nums[j]*nums[j];
            int sq2 = nums[k]*nums[k];
            if(sq1 < sq2) {
                ans[i++] = sq1;
                j++;
            }
            else {
                ans[i++] = sq2;
                k--;
            } 
        }
        while(k>-1){
            ans[i++] = nums[k]*nums[k];
            k--;
        }
        while (j<len){
            ans[i++] = nums[j]*nums[j];
            j++;
        }
        return ans;
        
    }
}
