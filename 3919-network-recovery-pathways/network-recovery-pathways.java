

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;

        // Filter and build the graph using only online nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if (online[u] && online[v]) {
                graph[u].add(new int[]{v, cost});
                minWeight = Math.min(minWeight, cost);
                maxWeight = Math.max(maxWeight, cost);
            }
        }

        // If no edges connect online nodes, no path can exist
        if (minWeight == Integer.MAX_VALUE) return -1;

        int left = minWeight;
        int right = maxWeight;
        int ans = -1;

        // Binary search for the maximum possible minimum edge cost
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(graph, n, mid, k)) {
                ans = mid;
                left = mid + 1; // Try to find a larger minimum edge cost
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean isValid(List<int[]>[] graph, int n, int threshold, long k) {
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[0] = 0;

        // Min-heap storing {cost_so_far, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long cost = current[0];
            int u = (int) current[1];

            if (u == n - 1) return cost <= k;
            if (cost > minCost[u]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Only traverse edges that satisfy the binary search threshold
                if (weight >= threshold) {
                    long nextCost = cost + weight;
                    if (nextCost < minCost[v]) {
                        minCost[v] = nextCost;
                        pq.add(new long[]{nextCost, v});
                    }
                }
            }
        }
        return minCost[n - 1] <= k;
    }
}


        
    
