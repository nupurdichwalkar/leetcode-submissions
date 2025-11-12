class Solution {

    boolean isValid(int num) {
        Map<Integer, Integer> numMap = new HashMap<>();
        while(num > 0) {
            int unit = num%10;
            numMap.put(unit, numMap.getOrDefault(unit, 0) + 1);
            if(numMap.get(unit) > unit) {
                return false;
            }
            num = num/10;
        }
        for(int n: numMap.keySet()){
            int val = numMap.get(n);
            if(n != val) {
                return false;
            }
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        while(true) {
            n = n+1;
            if(isValid(n)) {
                return n;
            }
        }
    }
}
