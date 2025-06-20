class Solution {
    Set<Integer> seen = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen.add(0);
        dfs(0, rooms);
        if (seen.size() == rooms.size()) {
            return true;
        }
        return false;
    }

    public void dfs (int room_num, List<List<Integer>> rooms) {
        for (int room : rooms.get(room_num)) {
            if (!seen.contains(room)) {
                seen.add(room);
                dfs(room, rooms);
            }
        }
    }


}
