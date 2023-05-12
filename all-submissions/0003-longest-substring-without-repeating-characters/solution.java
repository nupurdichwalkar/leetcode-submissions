class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r,0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l,chars.get(l) - 1 );
                left++;
            }
            count = Math.max(count, right-left+1);
            right++;
        }
        
        return count;
        
    }
}
