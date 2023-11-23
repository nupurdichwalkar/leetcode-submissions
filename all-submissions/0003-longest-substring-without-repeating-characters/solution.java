class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        set.add(s.charAt(0));
        int longestLength = 1;
        int currLength = 1;
        int right = 1;
        while(right<s.length()) {
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                currLength++;
                longestLength = Math.max(longestLength, currLength);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
                currLength--;
            }
            
        }
        return longestLength;
    }
}
