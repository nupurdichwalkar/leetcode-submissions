class Solution {
    public String reverseWords(String s) {
        if(s== null) return null;
        if(s.length() == 1) return s;
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = 0;
        while(sChar[right] != ' ' && right != s.length()-1) {
            right++;
            if (sChar[right] == ' ') {
                swapChars(sChar, left, right-1);
                right = right+1;
                left = right;
            }
        }
        swapChars(sChar, left, right);
        return new String(sChar);
    }

    private void swapChars(char[] sChar, int left, int right) {
        while(left<right){
            char temp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = temp;
            left++;
            right--;
        }
        return;
    }
}
