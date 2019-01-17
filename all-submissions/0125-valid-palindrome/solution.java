class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        s = s.toLowerCase();
        int start = 0; 
        int end = s.length()-1;
        
        while(start<end)
        {
             
            if(!(isValid(s.charAt(start))))
            {
                start++;
                continue;
            }
            if(!(isValid(s.charAt(end))))
            {
                end--;
                continue;
            }
               
           // System.out.println(start+","+ end );
            if(s.charAt(start) == s.charAt(end))
            {
               // System.out.println(s.charAt(start)+","+s.charAt(end));
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
    public boolean isValid(char c)
               {
                   if((c>='a'&& c<='z')||(c>='0'&& c<='9'))
                       return true;
                   
                   return false;
               }
}
