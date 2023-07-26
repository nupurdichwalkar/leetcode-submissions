class Solution {
    public int myAtoi(String s) {
        int answer = 0;
        int sign = 1;
        int numStart = 0;
        for(int i=0; i<s.length();i++) {
            if (s.charAt(i) != ' ') {
                numStart = i;
                break;
            }
        }
        if (numStart == s.length()) { return answer;}
        if (!Character.isDigit(s.charAt(numStart)) && s.charAt(numStart) != '-' && s.charAt(numStart) != '+') {
            return answer;
        }
        if(!Character.isDigit(s.charAt(numStart))){
            if (s.charAt(numStart) == '-'){
                sign = -1;
            } 
            numStart++;
        }
        for(int i=numStart; i<s.length(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return answer*sign;
            }
            if (answer > Integer.MAX_VALUE/10 || (answer == Integer.MAX_VALUE/10 && (s.charAt(i) - '0') > Integer.MAX_VALUE%10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            answer = answer*10+(s.charAt(i) - '0');
        }
        return answer * sign;


    }
}
