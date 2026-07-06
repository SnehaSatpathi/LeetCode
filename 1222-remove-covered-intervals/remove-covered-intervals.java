class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // ascending by start time, descending by end time
        java.util.Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int maxRight = -1;

        for (int[] interval : intervals) {
            // if the current interval's end is greater than the maxRight seen so far,
            // it's not covered by any previous interval.
            if (interval[1] > maxRight) {
                count++;
                maxRight = interval[1];
            }
        }

        return count;
    }
}


        
    
