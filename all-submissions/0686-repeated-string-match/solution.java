class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder s = new StringBuilder();
        int count=1;
        s.append(A);
        while(s.indexOf(B)<0)
        {
            if(s.length()-A.length()>B.length())
                return -1;
            count++;
            s.append(A);
        }
        return count;
    }
}
