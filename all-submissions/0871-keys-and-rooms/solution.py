class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = set()
        def dfs(room):
            if room not in visited:
                visited.add(room)
                for nr in rooms[room]:
                    dfs(nr)
        dfs(0)
        if len(visited) == n:
            return True
        return False
