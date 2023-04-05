class Solution {


    private int evaluate(Stack<Object> charStack) {

        if (charStack.empty() || !(charStack.peek() instanceof Integer)){
            charStack.push(0);
        }

        int res = (int) charStack.pop();

        while (!charStack.empty() && !((char) charStack.peek() == ')')) {
            char ch = (char) charStack.pop();

            if (ch == '+') {
                res += (int) charStack.pop();
            } else {
                res -= (int) charStack.pop();
            }
        }
        return res;
    }

    public int calculate(String s) {
        int digit = 0;
        int n = 0;
        Stack<Object> charStack = new Stack<Object>();


        for (int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digit = (int) Math.pow(10,n) * (int) (ch -'0') + digit;
                n+=1;
            } else if (ch != ' ') {
                if (n!= 0) {
                    charStack.push(digit);
                    digit = 0;
                    n = 0;
                }
                if (ch == '(') {
                    int res = evaluate(charStack);
                    charStack.pop();

                    charStack.push(res);
                } else {
                    charStack.push(ch);
                }
            }
        }
        if (n!=0) {
            charStack.push(digit);
        }

        return evaluate(charStack);
    }
}

