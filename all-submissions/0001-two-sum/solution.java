class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int i;
        for(i=0 ; i<nums.length ; i++){
            if (myMap.containsKey(target - nums[i])){
                break;
            }
            myMap.put(nums[i], i);
        }
        return new int[]{i,myMap.get(target - nums[i])};
    }
}
