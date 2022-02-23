class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return cloneSubgraph(node, new Node[100]);
    }
    
    public Node cloneSubgraph(Node node, Node[] arr) {
        // Get the cloned node from our array, or clone it if we don't have it.
        Node cloned = arr[node.val - 1];
        if (cloned == null) {
            arr[node.val - 1] = cloned = new Node(node.val);
        
            // If the cloned node should have neighbors, link them.
            if (!node.neighbors.isEmpty())
                for (Node nb: node.neighbors) cloned.neighbors.add(cloneSubgraph(nb, arr));
        }
        
        return cloned;
    }
}