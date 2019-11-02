class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int j = 1; j < s.length();j++){
            for(int i = 0; i < j; i++){
                boolean innerpalindrome = isPalindrome[i+1][j-1] || j-i <=2;
                
                if(s.charAt(i)==s.charAt(j) && innerpalindrome){
                    isPalindrome[i][j] = true;
                
                if(j-i > right-left){
                    left = i;
                    right = j;
                }
                }
            }
        }
        return s.substring(left, right+1);
    }
}
