

class Solution {
    public int minScore(int n, int[][] roads) {
        // adjacency list for the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            adj.get(u).add(new int[]{v, dist});
            adj.get(v).add(new int[]{u, dist});
        }
        
        // Use BFS to find all reachable nodes and track the minimum edge
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int dist = neighbor[1];
                
                // Update the minimum score with every edge encountered in this component
                minScore = Math.min(minScore, dist);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return minScore;
    }
}


        
    
