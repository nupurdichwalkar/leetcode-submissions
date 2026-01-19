class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        smallestString = min(strs, key=len)

        for i in range(len(smallestString)):
            for s in strs:
                if s[i] != smallestString[i]:
                    return res
            res += smallestString[i]

        return res 

