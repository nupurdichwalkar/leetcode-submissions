class Solution {

    public boolean longestPalindromeRecur(String s, int i, int j, boolean[][] dp) {
        if(i>=j) {
            return true;
        }
        if(dp[i][j] == true) return true;
        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = longestPalindromeRecur(s, i+1, j-1, dp);
        } else {
            dp[i][j]= false;
        }
        return dp[i][j];
    }

    public String longestPalindrome(String s) {
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(longestPalindromeRecur(s, i, j, dp)){
                    if(j-i+1 > result.length()){
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }
}
