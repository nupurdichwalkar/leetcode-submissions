class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        letter_set = ['a', 'b', 'c']
        combinations = []

        def backtrack(curr_str):
            if len(curr_str) == n:
                combinations.append(curr_str[:])
                return
            for j in range(len(letter_set)):
                if len(curr_str) > 0 and curr_str[-1] == letter_set[j]:
                    continue
                curr_str += letter_set[j]
                backtrack(curr_str)
                curr_str = curr_str[:-1]
            return
        
        backtrack("")
        index = 0
        ans = ""
        return combinations[k-1] if len(combinations) >=k else ""
        # if len(combinations) < k
        # while combinations_heap and index != k:
        #     ans = heapq.heappop(combinations_heap)
        #     index+=1
        # return ans if index == k else ""
