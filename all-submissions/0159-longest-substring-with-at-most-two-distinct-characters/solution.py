class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        char_map = {}
        left = 0
        right = 0
        maxLength = 0
        while(right<len(s)):
            char_map[s[right]] = char_map.get(s[right], 0)+1
            while len(char_map) > 2:
                char_map[s[left]] -=1
                if char_map[s[left]] == 0:
                    del char_map[s[left]]
                left +=1
            maxLength = max(maxLength, right-left+1)
            right +=1
        return maxLength

