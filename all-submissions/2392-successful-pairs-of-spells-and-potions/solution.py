class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        res = []
        for i in range(len(spells)):
            l = 0
            r = len(potions) - 1
            count = 0
            spell = spells[i]
            while l <= r:
                mid = (l+r)//2
                prod = spell * potions[mid]
                if prod >= success:
                    count += r-mid+1
                    r = mid-1
                else:
                    l = mid+1
            res.append(count)
        return res

