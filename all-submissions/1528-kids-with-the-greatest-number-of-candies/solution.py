class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        result = []
        curr_max = max(candies)
        for candy in candies:
            result.append(candy + extraCandies >= curr_max)
        return result
