class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int left = 0;
        int right = 0;
        int currCost = 0;
        int maxCount = 0;
        while(right < cs.length) {
             currCost += Math.abs(Character.getNumericValue(cs[right]) - Character.getNumericValue(ct[right]));
             if (currCost > maxCost) {
                 while(left <= right && currCost > maxCost) {
                     currCost = currCost - (Math.abs(Character.getNumericValue(cs[left]) - Character.getNumericValue(ct[left])));
                     left++;
                 }
             } else {
                maxCount = Math.max(maxCount, right-left+1);
             }
             right++;
        }
        return maxCount;
    }
}
