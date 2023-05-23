class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() % 2 == 1) return false;

        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            if (c == ')' || c == '}' || c == ']') {
                if (st.empty()) {
                    return false;
                }
                char t = st.pop();
                if (c == ')' && t != '(') {
                    return false;
                }
                if (c == '}' && t != '{') {
                    return false;
                }
                if (c == ']' && t != '[') {
                    return false;
                }
            }
        }
        if (st.empty())
         return true; 
        return false;
    }
    

}
