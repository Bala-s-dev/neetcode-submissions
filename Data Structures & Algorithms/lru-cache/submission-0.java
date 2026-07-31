class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void insertAfterHead(Node node){
        Node afterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = afterHead;
        afterHead.prev = node;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            if(map.size() == capacity){
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(node.key, node);
        }
    }
}
