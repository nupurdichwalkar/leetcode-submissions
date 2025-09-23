class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // if(target == 'z') return letters[0];
        // int len = letters.length;
        // if(letters[len-1] < target) return letters[0];

        // for(char c: letters){
        //     if(c > target){
        //         return c;
        //     }
        // }
        
        // return letters[0];


        int left = 0;
        int right = letters.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(letters[mid] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}
