class Solution {
    public boolean isHappy(int n) {
        int Square_Sum=n;
        while(Square_Sum!=1)
        {
             Square_Sum=sumsquare(Square_Sum);
            if(Square_Sum == 145)
                return false;
        }
        return true;
    }
    public int sumsquare(int n)
    {
        int sum = 0;
        while(n!=0)
        {
            sum += Math.pow(n%10,2);
            n /= 10;
        }
        return sum;
    }
}
