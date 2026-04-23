class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord:
            return 0

        l = len(beginWord)

        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(l):
                all_combo_dict[word[:i]+"*" + word[i+1:]].append(word)

        queue = deque()
        queue.append((beginWord, 1))
        visited = set()
        visited.add(beginWord)

        while queue:
            currword, level = queue.popleft()
            for i in range(l):
                intermediateword = currword[:i]+"*" + currword[i+1:]
                words = all_combo_dict[intermediateword]
                for word in words:
                    if word == endWord:
                        return level+1
                    if word not in visited:
                        visited.add(word)
                        queue.append((word, level+1))

        return 0


