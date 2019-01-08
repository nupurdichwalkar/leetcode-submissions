class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        HashMap<Character,Integer> anagramMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            Integer count = anagramMap.get(s.charAt(i));
            if(count == null)
            {
                anagramMap.put(s.charAt(i),1);
            }
            else
            {
                anagramMap.put(s.charAt(i),count+1);
            }
        }
        for(int i=0;i<t.length();i++)
        {  
            Integer count = anagramMap.get(t.charAt(i));
            if(count == null)
            {
              anagramMap.put(t.charAt(i),1);
            }
            else
            {
            if(count == 1)
            {
                anagramMap.remove(t.charAt(i));
            }
            else
            {
                anagramMap.put(t.charAt(i),count-1);
            }
            }
        }
        if(anagramMap.isEmpty())
            return true;
        else
            return false;
    }
}
