class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> answer = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex < firstList.length && secondIndex < secondList.length) {
            int lowerNumber = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int higherNumber = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
            if(lowerNumber <= higherNumber) {
                answer.add(new int[]{lowerNumber, higherNumber});
            }

            if(firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return answer.toArray(new int[answer.size()][]);

        
    }
}
