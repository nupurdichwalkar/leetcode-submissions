class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:

        maxDist = 0

        def findcurrMax(index):
            currMaxLeft = len(seats)
            currMaxRight =  len(seats)
            for i in range(index-1,-1,-1):
                if seats[i] == 1:
                    currMaxLeft = index-i
                    break
            for i in range(index+1, len(seats)):
                if seats[i] == 1:
                    currMaxRight = i-index
                    break
            return min(currMaxLeft, currMaxRight)


        for index, seat in enumerate(seats):
            if seat == 0:
                maxDist = max(maxDist, findcurrMax(index))

        return maxDist
