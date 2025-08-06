class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int j=0;
        int answer = 0;
        while(i<players.length && j< trainers.length) {
            if(players[i] <= trainers[j]) {
                answer++;
                i++;
                j++;
            } else{
                j++;
            }
        }
        return answer;
    }
}
