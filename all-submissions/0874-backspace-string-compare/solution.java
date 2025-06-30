class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if(c != '#') {
                sb.append(c);
            } else {
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }
        StringBuilder tb = new StringBuilder();
        for (char c: t.toCharArray()){
            if(c != '#') {
                tb.append(c);
            } else {
                if(tb.length() > 0){
                    tb.deleteCharAt(tb.length() - 1);
                }
            }

        }
        String newS = sb.toString();
        String newT = tb.toString();
        return newS.equals(newT);
        
        
    }
}
