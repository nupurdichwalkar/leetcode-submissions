public class Node{
    int val;
    Node next;
    Node(int x)
    {
        val = x ;
    }
}

class MyLinkedList {
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    //Helper Functions
    private Node getNode(int index)
    {
        Node curr = head;
        for(int i = 0; i<index && curr != null; i++)
        {
            curr = curr.next;
        }
        return curr;
    }
    
    private Node getTail()
    {
        Node curr = head;
        while(curr !=null && curr.next!= null)
        {
            curr = curr.next;
        }
        return curr;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node curr = getNode(index);
        if(curr!=null)
            return curr.val;
        else
            return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node curr = new Node(val);
        curr.next = head;
        head = curr;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newcurr = new Node(val);
        Node curr = getTail();
        
        newcurr.next = curr.next;
        curr.next = newcurr;

    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node curr = new Node(val);
        if(index == 0)
        {
            addAtHead(val);
            return;
        }
        Node prev = getNode(index-1);
        if(prev == null)
           return;
        curr.next = prev.next;
        prev.next = curr;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node curr = getNode(index);
        if(curr==null)
            return;
        Node prev = getNode(index-1);
        if(prev!=null)
        {
            prev.next = curr.next;
        }
        else
            head = curr.next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
