class Solution {

    List<String> result = new ArrayList<>();

    public void backtrack(StringBuilder s, int leftCount, int rightCount, int n) {
        if(s.length() == n*2) {
            result.add(s.toString());
            return;
        } 
        if (leftCount < n) {
            s.append("(");
            backtrack(s, leftCount+1, rightCount, n);
            s.deleteCharAt(s.length()-1);
        }

        if(leftCount > rightCount) {
            s.append(")");
            backtrack(s, leftCount, rightCount+1, n);
            s.deleteCharAt(s.length()-1);
        }


        

    }
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }
}
