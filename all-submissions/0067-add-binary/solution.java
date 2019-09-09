class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder result = new StringBuilder();
        
        while(i>=0||j>=0)
        {
            char charA = i>=0 ? a.charAt(i--) : '0';
            char charB = j>=0 ? b.charAt(j--) : '0';
            
            if (charA == '1' && charB == '1') {
				result = (carry) ? result.append('1') : result.append('0');
				carry = true;
            } else if (charA == '0' && charB == '0') { 
                result = (carry) ? result.append('1') : result.append('0');
                carry = false;
            } else { 
                result = (carry) ? result.append('0') : result.append('1');
            }
        }
            if(carry)
                result.append('1');
        
        return result.reverse().toString();
    }
}
