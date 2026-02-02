class Solution:
    def maxArea(self, height: List[int]) -> int:
        if height is None or len(height) == 1:
            return 0
        left = 0 
        right = len(height)-1
        maxWater = 0
        while(left<right):
            h = min(height[left], height[right])
            w = right - left
            currMax = h*w
            maxWater = max(maxWater, currMax)
            if height[left] < height[right]:
                left +=1
            else:
                right -=1
        return maxWater	


