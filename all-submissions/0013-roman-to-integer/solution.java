class Solution {
    public int romanToInt(String s) {
        int count  = 0;
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if (i != charArray.length-1) {
                if (charArray[i] == 'I' && (charArray[i+1] == 'V' || charArray[i+1] == 'X' ) ) {
                    count += romanToIntMap.get(charArray[i+1]) - romanToIntMap.get(charArray[i]);
                    i++;
                    continue;
                }
                if (charArray[i] == 'X' && (charArray[i+1] == 'L' || charArray[i+1] == 'C' ) ) {
                    count += romanToIntMap.get(charArray[i+1]) - romanToIntMap.get(charArray[i]);
                    i++;
                    continue;
                }
                if (charArray[i] == 'C' && (charArray[i+1] == 'D' || charArray[i+1] == 'M' ) ) {
                    count += romanToIntMap.get(charArray[i+1]) - romanToIntMap.get(charArray[i]);
                    i++;
                    continue;
                }
            }
            count += romanToIntMap.get(charArray[i]);
        }

        return count;
        
    }
}
