class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length(), left = 0, right = N;
        int[] A = new int[N + 1];
        for (int i = 0; i < N; i++)
            A[i] = S.charAt(i) == 'I' ? left++ : right--;
        A[N] = left;
        return A;
        
        
    }
}
