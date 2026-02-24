class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check(val):
            hours = 0
            for bananas in piles:
                hours += ceil(bananas/val)
            return hours <= h
        left = 1
        right = max(piles)
        while(left <= right):
            mid = (left + right) // 2
            if check(mid):
                right = mid-1
            else:
                left = mid+1
        return left
