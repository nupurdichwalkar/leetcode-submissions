class Solution {
    public String reversePrefix(String word, char ch) {
        int right = 0;
        char[] arr = word.toCharArray();
        for(int i=0;i<arr.length; i++){
            if (arr[i] == ch) {
                right = i;
                break;
            }
        }
        int left = 0;
        while(left<right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return new String(arr);
        
    }
}
