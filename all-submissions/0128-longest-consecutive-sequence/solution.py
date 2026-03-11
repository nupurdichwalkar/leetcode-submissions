class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        longest_streak = 0
        visited = set()
        for num in nums_set:
            if num in visited:
                continue
            curr_streak = 1
            while num+1 in nums_set:
                visited.add(num)
                num+=1
                curr_streak +=1
            visited.add(num)
            longest_streak = max(longest_streak, curr_streak)
        return longest_streak
