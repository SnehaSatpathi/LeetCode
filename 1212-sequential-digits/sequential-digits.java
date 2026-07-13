class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();
        
        // loop through all possible lengths of sequential digits (from 2 to 9)
        for (int length = 2; length <= 9; length++) {
            // Slide a window of 'length' over the digits string
            for (int start = 0; start <= 9 - length; start++) {
                String sub = digits.substring(start, start + length);
                int num = Integer.parseInt(sub);
                
                // add to result if it falls within the inclusive range
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}