class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = 0;
        int subStrSize = 0;
        int count = 0;
        while(r < s.length()){
            char rChar = s.charAt(r);
            myMap.put(rChar, myMap.getOrDefault(rChar,0)+1);
            while(myMap.size() > 2) {
                char lChar = s.charAt(l);
                if (myMap.get(lChar) > 1){
                    myMap.put(lChar, myMap.get(lChar)-1);
                } else {
                    myMap.remove(lChar);
                }
                subStrSize--;
                l++;
            } 
            subStrSize++;
            count = Math.max(count, subStrSize);
            r++;
        }
        return count;
        
    }
}
