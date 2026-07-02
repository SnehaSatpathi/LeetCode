




public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Directions array for moving: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // maxHealth[i][j] stores the maximum health we can have upon reaching cell (i, j)
        int[][] maxHealth = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(maxHealth[i], -1);
        }
        
        // Queue stores array: {row, col, currentHealth}
        Queue<int[]> queue = new ArrayDeque<>();
        
        // Compute initial health after stepping onto the starting cell (0, 0)
        int initialHealth = health - grid.get(0).get(0);
        if (initialHealth <= 0) {
            return false;
        }
        
        queue.offer(new int[]{0, 0, initialHealth});
        maxHealth[0][0] = initialHealth;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int h = current[2];
            
            // Short-circuit check: if this element is already outdated, skip it
            if (h < maxHealth[r][c]) {
                continue;
            }
            
            // Goal check
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Boundary check
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextHealth = h - grid.get(nr).get(nc);
                    
                    // Only traverse if remaining health is positive 
                    // AND it yields strictly more health than previously recorded at that cell
                    if (nextHealth > 0 && nextHealth > maxHealth[nr][nc]) {
                        maxHealth[nr][nc] = nextHealth;
                        queue.offer(new int[]{nr, nc, nextHealth});
                    }
                }
            }
        }
        
        return false;
    }
}

  
        
    
