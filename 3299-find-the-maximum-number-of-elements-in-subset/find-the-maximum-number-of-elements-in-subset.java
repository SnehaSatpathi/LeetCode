

public class Solution {
    public int maximumLength(int[] nums) {
        //  Sort to group identical numbers together
        Arrays.sort(nums);
        int n = nums.length;

        //  Compress into unique values and their frequencies
        long[] values = new long[n];
        int[] counts = new int[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            if (uniqueCount > 0 && values[uniqueCount - 1] == nums[i]) {
                counts[uniqueCount - 1]++;
            } else {
                values[uniqueCount] = nums[i];
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        int maxLen = 0;

        //  Handle special case for 1
        if (values[0] == 1) {
            int countOne = counts[0];
            maxLen = (countOne % 2 == 0) ? countOne - 1 : countOne;
        }

        //  Process all other numbers > 1
        for (int i = 0; i < uniqueCount; i++) {
            long curr = values[i];
            if (curr == 1) continue;

            int currentLen = 0;
            int currIdx = i;

            // Build the chain using binary search instead of map lookups
            while (currIdx >= 0 && counts[currIdx] >= 2) {
                currentLen += 2;
                long nextTarget = curr * curr;
                
                // Break early if squaring exceeds the max possible value to avoid overflow
                if (nextTarget > 1_000_000_000) {
                    currIdx = -1; // Force break
                    break;
                }
                
                curr = nextTarget;
                currIdx = Arrays.binarySearch(values, 0, uniqueCount, curr);
            }

            // Check if the final number can act as a valid peak
            if (currIdx >= 0) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}


        
    
