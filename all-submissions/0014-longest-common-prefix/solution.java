

import static java.lang.Integer.max;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for(String s: strs) {
            minLength = Math.min(minLength, s.length());
        }
        for(int i=0;i<minLength;i++) {
            if(strs[0].length() <= i) return sb.toString();
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length;j++) {
                if(strs[j].length() <=i) return sb.toString();
                char d = strs[j].charAt(i);
                if(c !=d )return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
        
    }
}
