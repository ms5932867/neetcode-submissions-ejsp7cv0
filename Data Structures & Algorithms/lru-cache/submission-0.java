class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        Node(Node prev, Node next, int key, int val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, Node> map;
    Node first;
    Node last;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        first = new Node(null, null, -1, -1);
        last = new Node(first, null, -1, -1);
        first.next = last;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        removeNode(cur);
        addNode(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        addNode(new Node(null, null, key, value));
        map.put(key, last.prev);
        System.out.println(key + " " + value + " " + map.size() + " " + cap);
        if (map.size() > cap) {
            map.remove(first.next.key);
            removeNode(first.next);
        }
    }
    // always add before last
    private void addNode(Node node) {
        Node prev = last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = last;
        last.prev = node;
    }
    // any node can be removed
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
