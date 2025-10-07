class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        if(s.length() == 0) return s;
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty()) {
                Pair<Character, Integer> curr = stack.peek();
                if (curr.getKey() == c) {
                    int val = curr.getValue()+1;
                    if(val == k) {
                        while(!stack.isEmpty() && stack.peek().getKey() == c) {
                            stack.pop();
                        }
                        continue;
                    } else {
                        stack.push(new Pair(c, val));
                    }
                } else {
                    stack.push(new Pair(c, 1));
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop().getKey());
        }
        return sb.reverse().toString();
        
    }
}
