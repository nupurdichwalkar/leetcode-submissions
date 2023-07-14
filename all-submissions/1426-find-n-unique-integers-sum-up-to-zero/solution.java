class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int num = n/2 * -1;
        for (int i=0; i<n ;i++){
            if (n%2 == 0) {
                if (num == 0) {
                    num++;
                }
            }
            ans[i] = num;
            num++;
        }
        return ans;
    }
}
