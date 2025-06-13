class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        int ansIndex = 0;
        char[] chArr = s.toCharArray();
        for (int i=0; i<chArr.length; i++) {
            if (set.contains(chArr[i])) {
                ansIndex = i;
                break;
            }
            set.add(chArr[i]);
        }
        return chArr[ansIndex];
    }
}
