class Solution {
    public boolean isValid(String s) {
        if(s=="")
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;  i<s.length(); i++ )
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case '{':
                case '(':
                case '[':
                    {
                    stack.push(ch);
                    break;
                    }
                case '}':
                case ']':
                case ')':
                    if(!stack.empty())
                    {
                        char c = stack.pop();
                        if((ch =='}' && c!='{') || (ch ==']' && c!='[') ||(ch==')' && c!='(') )
                            return false;
                    }
                    else
                        return false;
                default:
                    break;
            }
        }
        if(!stack.empty())
            return false;
        return true;
        
    }
}
