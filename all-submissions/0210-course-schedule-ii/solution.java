class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        List<Integer> topologicalOrderList = new ArrayList<>();

        for(int[] prereq: prerequisites) {
            int dest = prereq[0];
            int src = prereq[1];
            if(!courseMap.containsKey(src)) {
                courseMap.put(src, new ArrayList<>());
            }
            courseMap.get(src).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            topologicalOrderList.add(course);
            if(courseMap.containsKey(course)) {
                List<Integer> neighbors = courseMap.get(course);
                for(int neighbor: neighbors) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        if(topologicalOrderList.size() != numCourses) return new int[0];
        int i=0;
        for(int course: topologicalOrderList){
            topologicalOrder[i++] = course;
        }
        return topologicalOrder;

    }
}
