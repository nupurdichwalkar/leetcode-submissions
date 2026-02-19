class HitCounter:

    def __init__(self):
        self.hit_counter = defaultdict(int)

    def hit(self, timestamp: int) -> None:
        self.hit_counter[timestamp] +=1

    def getHits(self, timestamp: int) -> int:
        totalCount = 0
        diff = timestamp-300 if timestamp >= 300 else 0
        for t in self.hit_counter.keys():
            if diff < t <= timestamp:
                totalCount += self.hit_counter[t]
        return totalCount
            


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
