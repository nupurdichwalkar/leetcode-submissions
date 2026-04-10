class ListNode:

    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dic = {}   #key to ListNode
        self.head = ListNode(-1,-1)
        self.tail = ListNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def add(self, node):
        previous_end = self.tail.prev
        previous_end.next = node
        node.prev = previous_end
        node.next = self.tail
        self.tail.prev = node

    def remove(self, node):
        node.next.prev = node.prev
        node.prev.next = node.next
        
    def get(self, key: int) -> int:
        if not key in self.dic:
            return -1
        
        node = self.dic[key]
        self.remove(node)
        self.add(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            old_node = self.dic[key]
            self.remove(old_node)
        
        node = ListNode(key, value)
        self.dic[key] = node
        self.add(node)

        if len(self.dic) > self.capacity:
            node_to_remove = self.head.next
            self.remove(node_to_remove)
            del self.dic[node_to_remove.key]


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
