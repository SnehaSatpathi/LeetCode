class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length; 
        int total = m * n;
        k %= total; 

  
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }


        for (int i = 0; i < total; i++) {
            int originalRow = i / n;
            int originalCol = i % n;
            
            int targetIndex = (i + k) % total;
            int targetRow = targetIndex / n;
            int targetCol = targetIndex % n;
            
            result.get(targetRow).set(targetCol, grid[originalRow][originalCol]);
        }

        return result;
    }
}

        
    
