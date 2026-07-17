import java.util.Arrays;

public class Solution {
    // Renamed to gcdValues to match the LeetCode driver script
    public int[] gcdValues(int[] nums, long[] queries) {
        // Find the maximum value in nums to define our sieve size
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 1: Count frequency of each number in nums
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Count how many elements are multiples of each number i
        long[] countMultiples = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                countMultiples[i] += freq[j];
            }
        }

        // Step 3: Calculate the number of pairs whose GCD is exactly i
        long[] gcdPairsCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalElements = countMultiples[i];
            // Total combinations of pairs formed by multiples of i
            long totalPairs = totalElements * (totalElements - 1) / 2;
            
            // Subtract pairs that have a larger common divisor (multiples of i)
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdPairsCount[j];
            }
            gcdPairsCount[i] = totalPairs;
        }

        // Step 4: Compute prefix sums of the pair counts
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdPairsCount[i];
        }

        // Step 5: Answer each query using binary search
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIdx = queries[i];
            
            int low = 1, high = maxVal;
            int result = maxVal;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > targetIdx) {
                    result = mid; // Candidate GCD found, try to find a smaller one
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            answer[i] = result;
        }

        return answer;
    }
}


        
    
