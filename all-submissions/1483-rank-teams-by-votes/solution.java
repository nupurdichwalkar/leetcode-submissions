class Solution {

    class TeamVotes implements Comparable<TeamVotes>{
        String team;
        int[] votes = new int[26];

        TeamVotes(String team){
            this.team = team;
        }

        public void addVote(int index){
            votes[index]++;
        }

        @Override
        public int compareTo(TeamVotes other){
            int i = 0;
            while(i<26 && this.votes[i] == other.votes[i]){
                i++;
            }

            if(i==26) {
               return this.team.compareTo(other.team);
            } else {
                return other.votes[i] - this.votes[i];
            }
        }
    }

    public String rankTeams(String[] votes) {
        if(votes.length==0) return null;
        if(votes.length==1) return votes[0];
        TeamVotes[] tVotes = new TeamVotes[26];

        for(String s: votes[0].split("")) {
            int index = s.charAt(0) - 'A';
            tVotes[index] = new TeamVotes(s);
            System.out.println(tVotes[index].team);
        }

        for(String vote: votes){
            int index = 0;
            for(String s: vote.split("")){
                int teamIndex = s.charAt(0) - 'A';
                tVotes[teamIndex].addVote(index);
                index++;
            }
        }

        PriorityQueue<TeamVotes> priorityQueue = new PriorityQueue<>();
        for(String s: votes[0].split("")){
            TeamVotes t = tVotes[s.charAt(0) - 'A'];
            priorityQueue.add(t);
        }
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll().team);
        }
        return sb.toString();
    }
}
