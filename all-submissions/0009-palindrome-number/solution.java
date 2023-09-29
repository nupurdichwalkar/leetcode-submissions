

class Solution {
    public boolean isPalindrome(int x) {
        // String s = String.valueOf(x);
        // StringBuilder sBuilder = new StringBuilder();
        // sBuilder.append(s);
        // sBuilder.reverse();
        // if(s.equals(sBuilder.toString())) {
        //     return true;
        // }
        // return false;
        
        if (x < 0) { return false; }
        int num = 0;
        int temp = x;
        while(temp != 0){
            int rem = temp%10;
            num = num*10 + rem;
            temp = temp/10;
        }

        return x == num;
        
    }
}
