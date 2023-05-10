class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.empty()){
            char c = stack.pop();
            str.append(c);
        }
        if (str != null) {
            str.reverse();
        }   
        return str.toString();


        
    }
}
