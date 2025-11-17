class Solution {
    public int unequalTriplets(int[] nums) {
      int answer = 0;
      if(nums.length < 3) return 0;
      for(int i=0;i<nums.length-2; i++){
        for(int j=i+1; j< nums.length-1;j++){
            for(int k=j+1; k<nums.length;k++){
                if(nums[i] != nums[j]&& nums[i] != nums[k]&& nums[j] != nums[k]) answer++;
            }
        }
      }
      return answer;
    }
}
