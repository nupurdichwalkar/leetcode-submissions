class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for(int i=0; i<nums.length; i++) {
            int firstNum = nums[i];
            int secondNum = target - nums[i];
            if (map.containsKey(secondNum)) {
                int secondIndex = map.get(secondNum);
                if (secondIndex != i) {
                    answer[0] = i;
                    answer[1] = map.get(secondNum);
                    break;
                }
            }
            map.put(nums[i], i);
        } 
        return answer;
    }
}
