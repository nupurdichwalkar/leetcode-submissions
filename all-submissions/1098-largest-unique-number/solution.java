class Solution {
    public int largestUniqueNumber(int[] nums) {
    
        int largestNum = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            int val = map.get(key);
            if ( val == 1) {
                largestNum = Math.max(largestNum, key);
            }
        }
        return largestNum;
        
    }
}
