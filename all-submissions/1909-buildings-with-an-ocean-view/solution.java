class Solution {
    public int[] findBuildings(int[] heights) {
        int currMaxHeight = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        if(heights.length == 1) return new int[]{0};
        for(int i=heights.length-1; i>=0; i--){
            if(heights[i] > currMaxHeight) {
                ans.add(i);
                currMaxHeight = heights[i];
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
        
    }
}
