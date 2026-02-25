class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        if len(dist) > ceil(hour):
            return -1
        def check(speed):
            h = 0
            for d in dist:
                h = ceil(h)
                h += d/speed
            return h <= hour
        max_speed = 10 ** 7
        min_speed = 1
        while(min_speed <= max_speed):
            mid = (min_speed + max_speed)//2
            if check(mid):
                max_speed = mid -1
            else:
                min_speed = mid+1
        return min_speed

