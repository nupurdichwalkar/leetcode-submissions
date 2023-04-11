class Solution {
    public int findDuplicate(int[] nums) {
        int[] isPresent = new int[nums.length];
        Arrays.fill(isPresent, 0);
        for(int i =0 ; i< nums.length; i++) {
            if (isPresent[nums[i]-1] == 1) {
                return nums[i];
            }
            isPresent[nums[i]-1] = 1;
        }
        return -1;
    }
}
