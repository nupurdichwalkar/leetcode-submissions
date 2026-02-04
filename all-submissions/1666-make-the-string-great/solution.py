class Solution:
    def makeGood(self, s: str) -> str:
        end = 0
        st = list(s)
        for i in range(len(st)):
            if (end > 0 and abs(ord(st[i]) - ord(st[end-1])) == 32):
                end -=1
            else:
                st[end] = st[i]
                end +=1
        return "".join(st[0:end])
