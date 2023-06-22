class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if (spells.length == 0) return new int[]{0};
        int[] answer = new int[spells.length];
        int count;
        Arrays.sort(potions);
        for (int i = 0; i<spells.length;i++) {
            // if (potions[potions.length-1] * spells[i] < success) {
            //     count = 0;
            // } else {
                count = binarySearch(spells[i], potions, success);
            // }
            answer[i] = count;
        }
        return answer;
    }

    private int binarySearch(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length-1;
        while(left <=right) {
            int mid = left + (right-left) /2;
            if (potions[mid] * (long) spell < success) {
                left = mid +1;
            }
            else if (potions[mid] * (long) spell >= success) {
                right = mid-1;
            }
        }
        return potions.length - left;
    }
}
