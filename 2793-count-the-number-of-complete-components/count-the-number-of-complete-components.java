

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        //  the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        // iterate through all vertices to find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] counts = new int[2]; 
                // counts[0] = vertex count, counts[1] = edge count

                dfs(i, adj, visited, counts);

                // Step 4: Check if the component is complete
                int V = counts[0];
                int E = counts[1];
                
                // For a complete component, the sum of degrees must equal V * (V - 1)
                if (E == V * (V - 1)) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }

    //  DFS traversal to count vertices and total edge degrees in the component
    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, int[] counts) {
        visited[u] = true;
        counts[0]++; // Increment vertex count
        counts[1] += adj.get(u).size(); // Accumulate the degree of the vertex

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, counts);
            }
        }
    }
}


        
    
