class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if(name.charAt(0) != typed.charAt(0)) return false;
        int n= 1;
        int t = 1;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        while(n < nameChar.length && t< typedChar.length) {
            if(nameChar[n] == typedChar[t]) {
                n++;
                t++;
            } else {
                if(typedChar[t] != nameChar[n-1]) {
                    return false;
                } 
                while(t<typedChar.length && typedChar[t] == nameChar[n-1]){
                    t++;
                }
            }
        }
        
        if(n == nameChar.length) {
            while(t<typedChar.length) {
                if(typedChar[t] != nameChar[n-1]) {
                    return false;
                }
                t++;
            }
        }
        if(n == nameChar.length && t == typedChar.length) return true;
        return false;
    }
}
