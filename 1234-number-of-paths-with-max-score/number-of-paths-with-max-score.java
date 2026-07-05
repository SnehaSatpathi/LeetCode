class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] dpScore = new int[n][n];
        int[][] dpPaths = new int[n][n];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dpScore[i], -1);
        }

        dpScore[n - 1][n - 1] = 0;
        dpPaths[n - 1][n - 1] = 1;

        int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};

        for (int r = n - 1; r >= 0; r--) {
            String rowStr = board.get(r);
            for (int c = n - 1; c >= 0; c--) {
                if (rowStr.charAt(c) == 'X' || dpScore[r][c] == -1) {
                    continue;
                }

                int currScore = dpScore[r][c];
                int currPaths = dpPaths[r][c];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && board.get(nr).charAt(nc) != 'X') {
                        char nxtChar = board.get(nr).charAt(nc);
                        int nxtVal = (nxtChar == 'E') ? 0 : (nxtChar - '0');

                        int newScore = currScore + nxtVal;

                        if (newScore > dpScore[nr][nc]) {
                            dpScore[nr][nc] = newScore;
                            dpPaths[nr][nc] = currPaths;
                        } else if (newScore == dpScore[nr][nc]) {
                            dpPaths[nr][nc] = (dpPaths[nr][nc] + currPaths) % MOD;
                        }
                    }
                }
            }
        }

        if (dpScore[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{dpScore[0][0], dpPaths[0][0]};
    }
}


        
    
