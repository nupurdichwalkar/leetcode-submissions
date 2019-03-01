class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(char i : str)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int check = 0;
        for(int count : map.values())
        {
            if(count%2!=0)
                check++;
            if(check>1)
                return false;
        }
        return true;
    }
}
