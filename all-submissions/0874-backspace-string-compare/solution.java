class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for (char c: s.toCharArray()){
            if (!s1.empty() && c == '#') {
                s1.pop();
            }
            else if (c != '#') {
                s1.push(c);
            }
        }

        for (char c: t.toCharArray()){
            if (!t1.empty() && c == '#') {
                t1.pop();
            }
            else if (c != '#'){
                t1.push(c);
            }
        }

        while (!s1.empty() && !t1.empty()) {
            if (s1.pop() != t1.pop()){
                return false;
            }
        }
        if (s1.empty() && t1.empty()) {
            return true;
        }
        return false;
    }
}
