from collections import Counter

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0: return 0
        if len(s) == 1: return 1
        chars = {}
        left = 0
        answer = 0
        for right, c in enumerate(s):
            chars[c] = chars.get(c,0) +1
            if (chars[c] > 1):
                while (left < right and chars[c] > 1):
                    chars[s[left]] -=1
                    if chars[s[left] ] == 0:
                        del chars[s[left]]
                    left +=1
            answer = max(answer, right-left +1)
        return answer

