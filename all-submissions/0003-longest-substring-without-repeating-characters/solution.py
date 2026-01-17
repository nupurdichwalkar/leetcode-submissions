class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        left =0
        right=0
        max_count = 0
        s_dict = dict()
        while(right < len(s)):
            r_char = s[right]
            if r_char in s_dict:
                s_dict[r_char] += 1
            else:
                s_dict[r_char] = 1
            while(s_dict[r_char] > 1):
                l_char = s[left]
                if l_char in s_dict:
                    s_dict[l_char] -=1
                left += 1
            max_count = max(max_count, right-left + 1)
            right += 1
        return max_count

