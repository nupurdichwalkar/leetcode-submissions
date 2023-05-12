class Solution {
    public int reverse(int x) {
        int answer = 0;
        while (x != 0) {
            int num = x%10;
            x /= 10;
            if (answer > Integer.MAX_VALUE/10 ) return 0;
            if (answer < Integer.MIN_VALUE/10 ) return 0;
            answer = answer * 10 + num;
        }
        return answer;
    }
}
