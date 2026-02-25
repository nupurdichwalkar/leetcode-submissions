class Solution:
    def findBestValue(self, arr: List[int], target: int) -> int:
        def check(val):

            curr_sum = 0
            for num in arr:
                if num > val:
                    num = val
                curr_sum += num
            return curr_sum
            
        left = 0
        right = max(arr)
        while(left<=right):
            mid = (left + right)//2
            curr_s = check(mid)
            if curr_s == target:
                return mid
            elif curr_s < target:
                left = mid+1
            else:
                right = mid-1
        return left if abs(check(left)-target) < abs(check(left-1) - target) else left-1

