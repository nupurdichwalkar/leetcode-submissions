class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> character = new Stack();
        int index = 0;
        String res = "";
        while(index< s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count +(s.charAt(index)-'0');
                    index++;
                }
                counts.push(count);
                
            } else if(s.charAt(index)=='[') {
                character.push(res);
                res = "";
                index++;
                
            } else if(s.charAt(index)==']') {
                StringBuilder temp = new StringBuilder();
                temp.append(character.pop());
                int count = counts.pop();
                while(count>0)
                {
                    temp.append(res);
                    count--;
                }
                res = temp.toString();
                index++;
                
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
