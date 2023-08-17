class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return combinations;
        }
        backtrack(0 , digits, new StringBuilder());
        return combinations;
    }

    public void backtrack(int index, String digits, StringBuilder combination){
        if(digits.length() == combination.length()){
            combinations.add(combination.toString());
            return;
        }
        System.out.print( " " + index);
        String possibleLetters = letters.get(digits.charAt(index));
        for(char letter: possibleLetters.toCharArray()){
            combination.append(letter);
            backtrack(index+1, digits, combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }
}
