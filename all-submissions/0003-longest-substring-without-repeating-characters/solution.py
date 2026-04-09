class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_dict = {}
        left = 0
        right = 0
        max_length = 0
        while(right < len(s)):
            char_dict[s[right]] = char_dict.get(s[right], 0) + 1
            while left < right and char_dict[s[right]] > 1:
                char_dict[s[left]] -=1 
                left +=1
                if char_dict[s[left]] == 0:
                    del char_dict[s[left]]
            max_length = max(max_length, right - left +1)
            right += 1
        return max_length
