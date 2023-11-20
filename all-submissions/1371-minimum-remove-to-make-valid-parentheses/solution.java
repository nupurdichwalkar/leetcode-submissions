class Solution {
    public String minRemoveToMakeValid(String s) {
        int parenthesisCounter = 0;

        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == ')') {
                if (parenthesisCounter > 0) {
                    st.push(c);
                    parenthesisCounter--;
                } 
            } else if (c == '(') {
                parenthesisCounter++;
                st.push(c);
            }
            else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            char c = st.pop();
            if(parenthesisCounter>0 && c == '(')
            {
                parenthesisCounter--;
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
        
    }
}
