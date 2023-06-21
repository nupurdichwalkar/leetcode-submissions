class Solution {
    Set<Integer> seen = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean canVisitAllRooms = false;
        int noOfRooms = rooms.size();
        seen.add(0);
        dfs(0, rooms, noOfRooms);
        if (seen.size() == noOfRooms) {
            return true;
        }
        return false;
    }

    private void dfs(int keyNo, List<List<Integer>> rooms, int noOfRooms) {
        for(int key: rooms.get(keyNo)) {
            if (!seen.contains(key)) {
                seen.add(key);
                dfs(key, rooms, noOfRooms);
            }
        }
    }
}
