class Solution {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = k-1;
        int currCount = getVowels(left, right, s);
        int maxCount = currCount;
        right++;
        while(right < s.length()) {
            if(vowels.contains(s.charAt(right))){
                currCount++;
            }
            if(vowels.contains(s.charAt(left))){
                currCount--;
            }
            left++;
            right++;
            maxCount = Math.max(currCount, maxCount);
        }
        return maxCount;
    }

    public int getVowels(int left, int right, String s) {
        int count = 0;
        for(int i = left; i<=right; i++) {
            if(vowels.contains(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
