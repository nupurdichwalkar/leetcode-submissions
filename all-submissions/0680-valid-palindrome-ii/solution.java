class Solution {
    public boolean validPalindrome(String s) {
        char[] sChar = s.toCharArray();
        int i = 0;
        int j = sChar.length-1;
        while(i<j){
            if (sChar[i] != sChar[j]) {
                return (checkPalindrome(sChar, i, j - 1) || checkPalindrome(sChar, i + 1, j));
            } else {
              i++;
              j--;
            }
        }
        return true;
    }

    private boolean checkPalindrome(char[] sChar, int i, int j) {
        while (i < j) {
            if (sChar[i] != sChar[j]) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
