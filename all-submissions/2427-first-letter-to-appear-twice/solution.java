class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> mySet = new HashSet<>();
        char[] arr = s.toCharArray();
        for(char c:arr) {
            if (mySet.contains(c)) {
                return c;
            }
            mySet.add(c);
        }
        return ' ';
    }
}
