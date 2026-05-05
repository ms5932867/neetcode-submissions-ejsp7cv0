class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(head, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        newNode.next = dfs(node.next, map);
        newNode.random = dfs(node.random, map);

        return newNode;
    }
}