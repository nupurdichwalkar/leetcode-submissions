class Solution:
    def maxArea(self, height: List[int]) -> int:
        left =0
        right = len(height) -1
        maxArea = 0
        if len(height) <= 1:
            return 0
        while(left<right):
            minHeight = min(height[left], height[right])
            
            currArea = minHeight * (right- left)
            maxArea = max(maxArea, currArea)
            if height[left] < height[right]:
                left+=1
            else: 
                right -=1
        return maxArea

