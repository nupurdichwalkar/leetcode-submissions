class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> aList = new ArrayList<>();
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int sum = (digits[i] + carry);
            carry = sum/10;
            sum = sum%10;
            aList.add(sum);
        }
        if(carry != 0) {
            aList.add(carry);
        }
        int[] intArray = new int[aList.size()];
        for (int i = 0; i < aList.size(); i++) {
            intArray[i] = aList.get(aList.size()-i-1); // Auto-unboxing occurs here
        }
        return intArray;
        
    }
}
