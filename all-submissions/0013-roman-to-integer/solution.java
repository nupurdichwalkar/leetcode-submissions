class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> RomanTable = new HashMap<Character,Integer>();
        //HashMap<String,Integer> SubTable = new HashMap<String,Integer>();
        int sum = 0, temp =0;
        RomanTable.put('I',1);
        RomanTable.put('V',5);
        RomanTable.put('X',10);
        RomanTable.put('L',50);
        RomanTable.put('C',100);
        RomanTable.put('D',500);
        RomanTable.put('M',1000);
        for (int i=0;i<s.length();i++)
        {
            if((i!=s.length()-1)&&(RomanTable.get(s.charAt(i+1))>RomanTable.get(s.charAt(i))))
            {
                temp = RomanTable.get(s.charAt(i+1)) - RomanTable.get(s.charAt(i));
                i++;
            }
            else
                temp = RomanTable.get(s.charAt(i));
            sum = sum + temp;
        }
        return sum;
    }
}
