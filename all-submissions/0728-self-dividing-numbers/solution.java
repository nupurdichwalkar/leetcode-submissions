class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> output = new ArrayList<Integer>();
        
        for(int i=left; i<=right; i++)
        {
            boolean check = true;
            for(char d:Integer.toString(i).toCharArray())
            {
                
                if(d != '0' && (i % (d-'0') == 0));
                else
                    check = false;
            }
            if(check==true)
                output.add(i);
        }
        return output;
    }
}
