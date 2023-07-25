class Solution {
    public String reverseOnlyLetters(String s) {
        if(s == null || s.length() == 1) return s;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length -1;
        while(left < right){
            if(Character.isLetter(arr[left]) && Character.isLetter(arr[right])){
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
            else if (Character.isLetter(arr[left])){
                right--;
            } else {
                left++;
            }
        } 
        return new String(arr); 
    }

}
