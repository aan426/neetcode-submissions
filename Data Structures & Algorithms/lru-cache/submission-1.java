class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> pairs; 
    Node leastRecent;
    Node mostRecent;
    int cap;

    public LRUCache(int capacity) {
        pairs = new HashMap<>();
        leastRecent = new Node(0, 0);
        mostRecent = new Node(0, 0);
        leastRecent.next = mostRecent;
        mostRecent.prev = leastRecent;
        cap = capacity;
    }
    
    public int get(int key) {
        if(pairs.containsKey(key)){
            remove(pairs.get(key));
            insert(pairs.get(key));
            return pairs.get(key).val;
        }
        return -1;
    }

    public void insert(Node curr){
        Node oldMRU = mostRecent.prev;
        oldMRU.next = curr;
        curr.prev = oldMRU;
        curr.next = mostRecent;
        mostRecent.prev = curr;
    }

    public void remove(Node curr){
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void put(int key, int value) {
        //everytime you do an operation check if the last element is the same as the current key
        if(pairs.containsKey(key)){
            Node newNode = pairs.get(key);
            newNode.val = value;
            pairs.put(key, newNode);
            remove(newNode);
            insert(newNode);
        }
        else{
            Node newNode = new Node(key, value);
            insert(newNode);
            pairs.put(key, newNode);
        }

        if(pairs.size() > cap){
            pairs.remove(leastRecent.next.key);
            remove(leastRecent.next);
        }
    }
}

/*
class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> pairs;
    Node head; // dummy, head.next = most recently used
    Node tail; // dummy, tail.prev = least recently used
    int cap;

    public LRUCache(int capacity) {
        pairs = new HashMap<>();
        cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node curr) {
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAtFront(Node curr) {
        Node oldFirst = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = oldFirst;
        oldFirst.prev = curr;
    }

    public int get(int key) {
        if (!pairs.containsKey(key)) return -1;
        Node node = pairs.get(key);
        remove(node);
        insertAtFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (pairs.containsKey(key)) {
            Node node = pairs.get(key);
            node.val = value;
            remove(node);
            insertAtFront(node);
        } else {
            Node newNode = new Node(key, value);
            pairs.put(key, newNode);
            insertAtFront(newNode);

            if (pairs.size() > cap) {
                Node lru = tail.prev;
                remove(lru);
                pairs.remove(lru.key);
            }
        }
    }
}
*/
