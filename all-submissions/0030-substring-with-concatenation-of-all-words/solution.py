class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        word_len = len(words[0])
        word_freq = Counter(words)
        k = len(words)
        n = len(s)
        substring_size = word_len * k


        def check(i):
            temp_freq = word_freq.copy()
            words_used = 0
            for j in range(i, i+substring_size, word_len):
                sub = s[j:j+word_len]
                if temp_freq[sub] > 0:
                    temp_freq[sub] -=1
                    words_used +=1
                else:
                    break
            return words_used == k



        ans = []
        for i in range(n-substring_size+1):
            if check(i):
                ans.append(i)
        return ans
