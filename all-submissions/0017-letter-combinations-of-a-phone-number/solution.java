class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) 
            return result;
        helper(result,digits,0,"");
        return result;
    }
    
    public void helper(List<String> result, String digits, int pos, String str)
    {
        
        if(pos>=digits.length()){
            result.add(str);
            return;
        }
        
        String letters = KEYS[digits.charAt(pos)-'0'];
        for(int i = 0; i<letters.length();i++){
            helper(result,digits,pos+1,str+letters.charAt(i));
        }
        
    }
}
