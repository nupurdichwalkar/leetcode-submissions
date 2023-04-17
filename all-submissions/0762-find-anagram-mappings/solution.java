class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int[] answer = new int[nums1.length];
        for (int i=0; i<nums2.length; i++) {
            myMap.put(nums2[i], i);
        }
        for(int i=0; i< nums1.length; i++) {
            answer[i] = myMap.get(nums1[i]);
        }
        return answer;
    }
}
