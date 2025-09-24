class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        if(x==0) return 0;
        long num;
        int left =2;
        int right =x/2;
        while(left<=right) {
            int mid = left + (right-left) /2;
            num = (long) mid*mid;
            if(num == x) return mid;
            else if(num > x) right = mid-1;
            else if(num < x) left= mid+1;
        }

        return right;
    }
}
