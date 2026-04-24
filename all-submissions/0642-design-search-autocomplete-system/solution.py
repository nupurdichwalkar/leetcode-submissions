class TrieNode:

    def __init__(self):
        self.children = {} # dict of char: TrieNode
        self.sentences = defaultdict(int)
        self.end = False

    def put(self, c, node):
        self.children[c] = node
    
    def contains_key(self, c):
        return c in self.children and self.children[c] is not None

    def get(self, c):
        return self.children[c]
    
    def set_end(self):
        self.end= True


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def add_to_trie(self, sentence, times):
        node = self.root
        for ch in sentence:
            if not node.contains_key(ch):
                node.put(ch, TrieNode())
            node = node.get(ch)
            node.sentences[sentence] += times
        node.set_end()

    def search_in_trie(self, string):
        node = self.root
        for ch in string:
            if not node.contains_key(ch):
                return []
            node = node.get(ch)
        return node.sentences

class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        self.trie = Trie()
        for sentence, times in zip(sentences, times):
            self.trie.add_to_trie(sentence, times)
        self.curr_string = ""

    def input(self, c: str) -> List[str]:
        if c == "#":
            self.trie.add_to_trie(self.curr_string, 1)
            self.curr_string = ""
            return []
        self.curr_string = self.curr_string + c
        result_dict = self.trie.search_in_trie(self.curr_string)
        if not result_dict:
            return []
        heap = []
        for sentence, count in result_dict.items():
            heapq.heappush(heap, (-count, sentence))
        result = []
        while heap and len(result) < 3:
            c, s = heapq.heappop(heap)
            result.append(s)
        return result


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)
