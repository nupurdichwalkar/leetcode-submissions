class Solution {
    public int minimumDeletions(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;
        
    }
}
