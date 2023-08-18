class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reservationMap = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            if (reservationMap.containsKey(reservedSeat[0])){
                Set<Integer> seatsSet = reservationMap.get(reservedSeat[0]);
                seatsSet.add(reservedSeat[1]);
                reservationMap.put(reservedSeat[0], seatsSet);
            } else {
                Set<Integer> seatsSet = new HashSet<>();
                seatsSet.add(reservedSeat[1]);
                reservationMap.put(reservedSeat[0], seatsSet);
            }
        }
        int answer = 2*(n - reservationMap.size());
        for(int row: reservationMap.keySet()){
            Set<Integer> seatsSet = reservationMap.get(row);
            boolean isLeftAisle = false, isRightAisle = false, isMiddle = false;
            for (int seat: seatsSet) {
                if(seat >= 2 && seat <= 5)
                    isLeftAisle = true;
                if(seat >= 6 && seat <= 9)
                    isRightAisle = true;
                if(seat >=4 && seat <= 7)
                    isMiddle = true;
                    
                if(isLeftAisle && isRightAisle && isMiddle){
                    break;
                }
            }
            if (!isLeftAisle) {
                answer++;
            }
            if (!isRightAisle) {
                answer++;
            }
            if (isLeftAisle && isRightAisle && !isMiddle) {
                answer++;
            }
        }
        return answer; 
    }
}
