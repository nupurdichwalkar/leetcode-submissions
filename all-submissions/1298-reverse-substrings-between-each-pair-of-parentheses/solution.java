class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if (c != ')') {
                st.push(c);
            }
            else {
                List<Character> tempCharacters = new ArrayList<>();
                while(st.peek()!= '(' ) {
                    char currChar = st.pop();
                    tempCharacters.add(currChar);
                }
                st.pop();
                while(!tempCharacters.isEmpty()){
                    st.push(tempCharacters.removeFirst());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
