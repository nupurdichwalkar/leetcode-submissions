class Solution {
    public boolean isValid(String s) {
        if(s=="")
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{'||ch == '[')
            {
                stack.push(ch);
            }
            else if(ch == ')'||ch =='}'||ch == ']')
            {
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(ch == ')' && c!='(' || ch == '}'&& c!='{' || ch == ']'&& c!='[')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
