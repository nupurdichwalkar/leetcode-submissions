class Solution {
    public String sortVowels(String s) {
        char[] sChar = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i','o','u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> vowelList = new ArrayList<>();
        for(int i = 0; i<sChar.length; i++){
            if (vowels.contains(sChar[i])) {
                vowelList.add(sChar[i]);
            }
        }
        Collections.sort(vowelList);
        int vowelListIndex = 0;
        char[] tChar = new char[sChar.length];
        for(int i=0;i<sChar.length; i++){
            if(!vowels.contains(sChar[i])){
                tChar[i] = sChar[i];
            } else {
                tChar[i] = vowelList.get(vowelListIndex++);
            }
        }
        return new String(tChar);
        
    }
}
