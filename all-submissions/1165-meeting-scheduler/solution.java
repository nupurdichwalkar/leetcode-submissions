class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int slots1Len = slots1.length;
        int slots2Len = slots2.length;
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<slots2Len; i++) {
            for(int j=0; j<slots1Len; j++) {
                int start1 = slots1[j][0];
                int end1 = slots1[j][1];
                int start2 = slots2[i][0];
                int end2 = slots2[i][1];
                if (start1 >= start2) {
                    int totalDuration = start1+duration;
                    if (totalDuration <= end1 && totalDuration <= end2) {
                        result.add(start1);
                        result.add(totalDuration);
                        return result;
                    }
                } else {
                    int totalDuration = start2+duration;
                    if (totalDuration <= end1 && totalDuration <= end2) {
                        result.add(start2);
                        result.add(totalDuration);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
