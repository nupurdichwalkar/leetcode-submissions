class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        int n = nums.length/3;
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : numCount.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if (count > n) {
                answer.add(num);
            }
        }
        return answer;
        
        
    }
}
