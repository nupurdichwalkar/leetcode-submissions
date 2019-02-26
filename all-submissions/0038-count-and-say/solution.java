class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        
        for(int i=2; i<=n; i++)
        {
            StringBuilder sb = new StringBuilder();
            char[] c = ans.toCharArray();
            int j = 0;
            while(j < c.length)
            {
                int count = 0;
                char charac = c[j];
                while(j < c.length && charac == c[j])
                {
                    count++;
                    j++;
                }
                sb = sb.append(count).append(charac);
                ans = sb.toString();
            }
        }
        return ans;
    }
}
