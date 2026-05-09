/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>(); //old:new
        return dfs(node, map);
    }
    private Node dfs(Node old, Map<Node, Node> map) {
        if (old == null) {
            return null;
        }
        if (map.containsKey(old)) {
            return map.get(old);
        }
        Node newNode = new Node(old.val, new ArrayList<>());
        map.put(old, newNode);
        for (Node oldNb: old.neighbors) {
            newNode.neighbors.add(dfs(oldNb, map));
        }
        
        return newNode;
    }
}