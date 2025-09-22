class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        if(s.length() == 1) return false;
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c: ch) {
            if(c == '(' || c == '[' || c =='{') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                char curr = st.peek();
                if ((curr == '(' && c == ')') || (curr == '[' && c == ']') || (curr == '{' && c == '}')) {
                    st.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
        
    }
}
