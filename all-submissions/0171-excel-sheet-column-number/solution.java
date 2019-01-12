class Solution {
    public int titleToNumber(String s) {
         char[] c= s.toCharArray();
        int ans=0;
        int j=0;
        for(int i=c.length-1;i>=0;i--)
        {
            ans+= Math.pow(26,j++)*(c[i]-'A'+1);
        }
    return ans;
    }
}
