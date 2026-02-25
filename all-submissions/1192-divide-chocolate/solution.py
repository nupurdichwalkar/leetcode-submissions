class Solution:
    def maximizeSweetness(self, sweetness: List[int], k: int) -> int:
        def check(s):
            cuts = 0
            min_sum = 0
            for sweet in sweetness:
                min_sum += sweet
                if min_sum >= s:
                    cuts +=1
                    min_sum = 0
            return cuts >= k+1


        left = 0
        right = sum(sweetness) + 1
        while left <= right:
            mid = (left+right)//2
            if check(mid):
                left = mid+1
            else:
                right = mid-1
        return left-1
