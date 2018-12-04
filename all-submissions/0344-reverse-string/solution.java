class Solution {
    public String reverseString(String s) {
        StringBuffer str = new StringBuffer();
        str.append(s);
        str.reverse();
        String A = str.toString();
        return A;
        
    }
}
