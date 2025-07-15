class Solution {
    
    Set<Integer> seen = new HashSet<>();
    Set<Integer> stack = new HashSet<>(); 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preReqMap = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if(!preReqMap.containsKey(course)){
                preReqMap.put(course, new HashSet<>());
                
            }
            preReqMap.get(course).add(prereq);
        }
        for(int course: preReqMap.keySet()) {
            if(!seen.contains(course)){
                if (isPrereqCyclic(course, preReqMap)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isPrereqCyclic(int course, Map<Integer, Set<Integer>> preReqMap) {
        seen.add(course);
        stack.add(course);

        for (Integer neighbor : preReqMap.getOrDefault(course, Collections.emptySet())) {
            if (!seen.contains(neighbor)) {
                if (isPrereqCyclic(neighbor, preReqMap)) {
                    return true;
                }
            } else if (stack.contains(neighbor)) {
                // Found a back edge → cycle
                return true;
            }
        }

        stack.remove(course);  // backtrack
        return false;
    }
}
