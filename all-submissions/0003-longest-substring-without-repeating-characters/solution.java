class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] arr = new int[256];
        while(right < s.length()){
            if(arr[s.charAt(right)] > 0) {
                while(s.charAt(left) != s.charAt(right)){
                    arr[s.charAt(left)]--;
                    left++;
                }
                arr[s.charAt(left)]--;
                left++;
            }
            arr[s.charAt(right)]++;
            right++;
            max = Math.max(max, right - left);
        }
        
        return max;
    }
}
