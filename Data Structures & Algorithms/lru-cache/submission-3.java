class LRUCache {
    class Node{
        Node prev = null;
        Node next = null;
        int key;
        int val;
        Node(int key, int val) {
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
        first = new Node( -1, -1);
        last = new Node( -1, -1);
        first.next = last;
        last.prev = first;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        removeNode(cur);
        addLast(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        Node cur;
        if (!map.containsKey(key)) {
            cur = new Node(key, value);
            addLast(cur);
            map.put(key, cur);
            if (map.size() > cap) {
                map.remove(first.next.key);
                removeNode(first.next);
            }
        } else {
            cur = map.get(key);
            removeNode(cur);
            cur.val = value;
            addLast(cur);
        }
    }
    // always add before last
    private void addLast(Node node) {
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
