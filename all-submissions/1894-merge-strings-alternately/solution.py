class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = []
        for i in range(min(len(word1), len(word2))):
            result.append(word1[i])
            result.append(word2[i])

        if len(word1) > len(word2):
            result.append(word1[len(word2):])
        elif len(word2) > len(word1):
            result.append(word2[len(word1):])
        return "".join(result)
        
