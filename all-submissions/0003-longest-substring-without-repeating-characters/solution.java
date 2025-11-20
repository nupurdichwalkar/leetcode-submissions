class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chArray = s.toCharArray();
        int left =0;
        int right =0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int longest = 0;
        while(right < chArray.length){
            freqMap.put(chArray[right], freqMap.getOrDefault(chArray[right], 0) + 1);
            if(freqMap.get(chArray[right]) > 1){
                while(freqMap.get(chArray[right]) > 1){
                    freqMap.put(chArray[left], freqMap.get(chArray[left])-1);
                    left++;
                }
            }
            longest = Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}
