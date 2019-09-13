class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result, "",n,n,n);
        return result;
    }
    public void helper(List<String> result, String str, int open, int close, int max)
    {
        if(str.length()==2*max)
        {
            result.add(str);
        }
        
        if(open>0)
        {
            helper(result,str+"(",open-1,close,max);
        }
        if(open<close)
        {
            helper(result,str+")",open,close-1,max);
        }
    }
}
