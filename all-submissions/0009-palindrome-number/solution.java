class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int newNum = revert(x);
        if (newNum == x)
            return true;
        else
            return false;
        
    }
    public int revert(int n)
    {
        int num = 0;
        while(n!=0)
        {
            num = num*10 + n%10;
            n = n/10;
        }
        return num;
    }
}
