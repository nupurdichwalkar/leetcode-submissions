public class Solution {
    public String reverseWords(String s) {
        String[] str_arr = s.trim().split(" ");
        // System.out.println(Arrays.toString(str_arr));
        StringBuilder str = new StringBuilder();
        for(int i = str_arr.length-1; i>=0; i--){
            if(str_arr[i].trim().length()>0){
                str.append(str_arr[i] + " ");
            }
        }
        // System.out.println(str.toString().trim());
        return str.toString().trim();
    }
}
