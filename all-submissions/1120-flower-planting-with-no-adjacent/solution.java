class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    

    public int[] gardenNoAdj(int n, int[][] paths) {

        // create the graph
        for(int i=0;i<paths.length;i++) {
            int first = paths[i][0];
            int second = paths[i][1];
            graph.computeIfAbsent(first, k->new ArrayList<>()).add(second);
            graph.computeIfAbsent(second, k-> new ArrayList<>()).add(first);
        }

        int[] answer = new int[n];
        for(int i=1; i<=n ;i++) {
            Set<Integer> flowerTypeTaken = new HashSet<>();
            List<Integer> neighbors = graph.get(i);
            if(neighbors != null){
                for(int neighbor: neighbors){
                    if (answer[neighbor-1] != 0){
                        flowerTypeTaken.add(answer[neighbor-1]);
                    }
                }
                for(int j=1;j<=4;j++) {
                    if(!flowerTypeTaken.contains(j)){
                        answer[i-1] = j;
                    }
                }
            } else {
                answer[i-1] = 1;
            }
        }
        return answer;
    }

}
