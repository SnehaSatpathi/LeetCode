class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;
        int[][] extended = new int[m + 2][2];
        
        
        for (int i = 0; i < m; i++) {
            extended[i][0] = restrictions[i][0];
            extended[i][1] = restrictions[i][1];
        }
        
        
        extended[m][0] = 1;
        extended[m][1] = 0;
        extended[m + 1][0] = n;
        extended[m + 1][1] = n - 1;
        
        
        Arrays.sort(extended, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalLen = extended.length;
        
        
        for (int i = 1; i < totalLen; i++) {
            int maxPossibleFromLeft = extended[i - 1][1] + (extended[i][0] - extended[i - 1][0]);
            extended[i][1] = Math.min(extended[i][1], maxPossibleFromLeft);
        }
        
        
        for (int i = totalLen - 2; i >= 0; i--) {
            int maxPossibleFromRight = extended[i + 1][1] + (extended[i + 1][0] - extended[i][0]);
            extended[i][1] = Math.min(extended[i][1], maxPossibleFromRight);
        }
        
        
        int maxHeight = 0;
        for (int i = 0; i < totalLen - 1; i++) {
            int id1 = extended[i][0];
            int h1 = extended[i][1];
            int id2 = extended[i + 1][0];
            int h2 = extended[i + 1][1];
            
            
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        return maxHeight;
    }
}