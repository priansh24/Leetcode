class LRUCache {
    int cap;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node newNode = map.get(key);
            remove(newNode);
            insert(newNode);
            return newNode.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(map.size()==cap)
        {
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node)
    {
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

class Node {
    Node next;
    Node prev;
    int key,value;
    Node(int k,int val)
    {
        key = k;
        value = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */