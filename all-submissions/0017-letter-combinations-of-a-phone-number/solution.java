class Solution {

    List<String> combinations = new ArrayList<>();
    Map<Character, String> letters = Map.of('2',"abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );



    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return combinations;
        StringBuilder sb = new StringBuilder();
        backtrack(0, sb, digits);
        return combinations;
    }

    public void backtrack (int index, StringBuilder sb, String digits) {
        if(sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        char[] charArray = letters.get(digits.charAt(index)).toCharArray();
        for(char c: charArray){
            sb.append(c);
            backtrack(index+1, sb, digits);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
