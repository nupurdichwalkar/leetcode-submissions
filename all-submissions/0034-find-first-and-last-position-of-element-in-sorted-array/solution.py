class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        def findLeftMostIndex():
            left = 0
            right = len(nums)-1
            while left < right:
                mid = (left + right) // 2
                if nums[mid] >= target:
                    right = mid
                else:
                    left = mid + 1

            return left if 0<=left<len(nums) and nums[left] == target else -1

        def findRightMostIndex():
            left = 0
            right = len(nums)-1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > target:
                    right = mid-1
                else:
                    left = mid + 1

            return right if 0<=right<len(nums)  and nums[right] == target else -1

        l =findLeftMostIndex()
        r = findRightMostIndex()
        return [l,r]
