class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;

    ListNode(int key, int value) {
        this.key= key;
        this.value = value;
    }
}


class LRUCache {
    int capacity;
    Map<Integer, ListNode> dict;
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        dict = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }
    
    public void remove(ListNode node) {
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(!dict.containsKey(key)) {
            return -1;
        }
        ListNode node = dict.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)) {
            ListNode nodetoUpdate = dict.get(key);
            remove(nodetoUpdate);
        }
        ListNode node = new ListNode(key, value);
        add(node);
        dict.put(key, node);

        if(dict.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dict.remove(nodeToDelete.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
