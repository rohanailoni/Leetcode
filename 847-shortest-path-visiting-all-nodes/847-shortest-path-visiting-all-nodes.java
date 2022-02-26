class Solution {
    
    class Gnode {
        int visited;
        int dist;
        int node;
        
        Gnode(int node, int dist, int visited) {
            this.node = node;
            this.dist = dist;
            this.visited = visited;
        }
    }
    public int shortestPathLength(int[][] graph) {
        // TC: O(2^n * n^2) ; SC: O(n * 2^n)
        int n = graph.length;
        
        // Visited Checks if we have already visited that node, eliminates infinite loop
        Set<Integer>[] visited = new HashSet[n];

        Queue<Gnode> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            queue.add(new Gnode(i, 0, 1 << i));
            visited[i].add(1 << i);
        }
		// BFS
        while(!queue.isEmpty()) {
            Gnode node = queue.poll();
            if(node.visited == (1 << n) - 1) 
                return node.dist;
            for(int val : graph[node.node]) {
			    
                int mask = node.visited | (1 << val);

                if(visited[val].add(mask)) {
                    queue.add(new Gnode(val, 1 + node.dist, mask));
                }
            }
        }
        return -1;
    }
}