class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        
        def dfs(i):
            chars.append(s[i])
            indices.append(i)
            visited.add(i)
            for neighbor in adj_list[i]:
                if neighbor not in visited:
                    dfs(neighbor)
        
        
        adj_list = defaultdict(list)
        for x,y in pairs:
            adj_list[x].append(y)
            adj_list[y].append(x)

        visited = set()
        ans = ['']*len(s)
        for i in range(len(s)):
            if i not in visited:
                chars = []
                indices = []
                dfs(i)
                chars.sort()
                indices.sort()
                for ch, idx in zip(chars, indices):
                    ans[idx] = ch
        
        return "".join(ans)
