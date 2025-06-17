class Solution {
    public int sumOfUnique(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()){
            int value = map.get(key);
            if(value ==1) {
                answer += key;
            }
        }
        return answer;
    }
}
