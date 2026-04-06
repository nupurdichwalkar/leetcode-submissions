class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict_map = defaultdict(list)
        for s in strs:
            st = "".join(sorted(s))
            dict_map[st].append(s)
        return list(dict_map.values())

