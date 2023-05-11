class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) { 
            if(!st.empty() && Math.abs(st.peek() - c) == 32) {
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb.append(st.pop());
        }
        if (sb != null) { 
            sb.reverse();
        }
        return sb.toString();
        
    }
}
