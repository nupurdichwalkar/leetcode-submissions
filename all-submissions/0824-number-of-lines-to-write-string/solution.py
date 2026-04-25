class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        l = 1
        cp = 0
        for ch in s:
            w = widths[ord(ch) - ord('a')]
            cp +=  w
            if cp > 100:
                l +=1
                cp = w
        return l, cp

