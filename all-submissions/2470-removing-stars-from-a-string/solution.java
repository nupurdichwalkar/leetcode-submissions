class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c != '*') {
                st.push(c);
            }
            else{
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }
        return new String(sb.reverse());
    }
}
