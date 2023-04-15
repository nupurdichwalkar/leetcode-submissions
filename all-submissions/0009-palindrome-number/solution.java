

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(s);
        sBuilder.reverse();
        if(s.equals(sBuilder.toString())) {
            return true;
        }
        return false;
        
    }
}
