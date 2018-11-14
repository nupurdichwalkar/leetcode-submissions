class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> output = new ArrayList<Integer>();
        
        for(int i=left; i<=right; i++)
        {
            if(check(i))
                output.add(i);
        }
        return output;
    }
    public boolean check(int i)
    {
            for(char d:Integer.toString(i).toCharArray())
            {
                
                if(d != '0' && (i % (d-'0') == 0));
                else
                    return false;
            }
        return true;
    }
}
