class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        return dp(n);
    }

    public int dp(int n) {
        if (n == 0) return 0;
        if(n == 1) return 1;
        if (n == 2) return 2;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int answer = dp(n-2) + dp(n-1) ;
        memo.put(n, answer);
        return answer;
    }
}
