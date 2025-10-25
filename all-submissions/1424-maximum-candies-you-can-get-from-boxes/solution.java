class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> boxes = new LinkedList<>();
        int answer = 0;
        boolean[] seen = new boolean[status.length];
        Set<Integer> existingKeys = new HashSet<>();
        Set<Integer> unopened = new HashSet<>();
        for(int initialBox: initialBoxes) {
            boxes.add(initialBox);
        }
        while(!boxes.isEmpty()){
            int currBox = boxes.poll();
            if((status[currBox] == 1 || existingKeys.contains(currBox))&& !seen[currBox]) {
                seen[currBox] = true;
                answer += candies[currBox];
                if(containedBoxes[currBox].length != 0) {
                    for (int containedBox: containedBoxes[currBox]) {
                        boxes.add(containedBox);
                    }
                }
                if(keys[currBox].length != 0){
                    for(int key: keys[currBox]){
                        existingKeys.add(key);
                        for(int u : unopened) {
                            if(existingKeys.contains(u) && !seen[u]) {
                                boxes.add(u);
                            }
                        }
                    }
                }
            } else {
                unopened.add(currBox);
            }
            
        }
        return answer;
    }
}
