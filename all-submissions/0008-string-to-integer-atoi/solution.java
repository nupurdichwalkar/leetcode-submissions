class Solution {
    public int myAtoi(String str) {
        String s = str.trim();
        double res = 0;
        double sign = 1;
        int i = 0;
        if(s.length() == 0)
            return 0;
        if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != '-' && s.charAt(i)!= '+' )
        {
            return 0;
        }
        if(s.charAt(i) == '-' || s.charAt(i) == '+' )
            {
                if(s.charAt(i) == '-')
                    sign = -1;
                i++;
            }
        while(i<s.length() && Character.isDigit(s.charAt(i)))
        {
            if(s.charAt(i) ==' ')
                return 0;
            res = res*10 + s.charAt(i)-'0';
            i++;
        } 
        double ans = res*sign;
        if(ans<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(ans>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        return (int)(res*sign);
    }
}
