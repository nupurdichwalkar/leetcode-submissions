class Solution:
    def halveArray(self, nums: List[int]) -> int:
        total = sum(nums)
        half = total/2
        heapq.heapify_max(nums)
        operations = 0
        print(total, half)
        while total > half:
            operations += 1
            max = heapq.heappop_max(nums)
            print(max)
            max_half = max/2
            total -= max_half
            heapq.heappush_max(nums, max_half)
        return operations
