class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        if not arr or len(arr) < 2:
            return True
        arr.sort()
        diff = arr[1]-arr[0]
        for i in range(1, len(arr)-1):
            curr_diff = arr[i+1]-arr[i]
            if curr_diff != diff:
                return False
        return True
