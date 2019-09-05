
class LRUCache {
    
    private class DNode {
      int key;
      int value;
      DNode prev;
      DNode next;
    }

    private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
    private DNode head, tail;
    private int totalItemsInCache;
    private int maxCapacity;

    public LRUCache(int maxCapacity) {

      totalItemsInCache = 0;
      this.maxCapacity = maxCapacity;

     
      head = new DNode();
      head.prev = null;

      
      tail = new DNode();
      tail.next = null;

      
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {

      DNode node = hashtable.get(key);
      boolean itemFoundInCache = node != null;

      
      if(!itemFoundInCache){
        return -1;
      }

      
      moveToHead(node);

      return node.value;
    }

    public void put(int key, int value) {

      DNode node = hashtable.get(key);
      boolean itemFoundInCache = node != null;

      if(!itemFoundInCache){

        DNode newNode = new DNode();
        newNode.key = key;
        newNode.value = value;

        hashtable.put(key, newNode);
        addNode(newNode);

        totalItemsInCache++;

        if(totalItemsInCache > maxCapacity){
          removeLRUEntryFromStructure();
        }

      } else {
        node.value = value;
        moveToHead(node);
      }

    }

    private void removeLRUEntryFromStructure() {
      DNode tail = popTail();
      hashtable.remove(tail.key);
      --totalItemsInCache;
    }

    private void addNode(DNode node){

      node.prev = head;
      node.next = head.next;

      head.next.prev = node;

      head.next = node;
    }

    private void removeNode(DNode node){

      DNode savedPrev = node.prev;
      DNode savedNext = node.next;

      savedPrev.next = savedNext;

      savedNext.prev = savedPrev;
    }
    private void moveToHead(DNode node){
      removeNode(node);
      addNode(node);
    }

    private DNode popTail(){
      DNode itemBeingRemoved = tail.prev;
      removeNode(itemBeingRemoved);
      return itemBeingRemoved;
    }

}

