class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int totalFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        for(int key: map.keySet()) {
            if (map.get(key) == maxFreq) {
                totalFreq += maxFreq;
            }
        }
        return totalFreq;
    }
}
