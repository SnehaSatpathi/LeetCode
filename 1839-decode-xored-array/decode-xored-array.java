class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        
        // The first element is given
        arr[0] = first;
        
        // Iterate through the encoded array to find the rest
        for (int i = 0; i < encoded.length; i++) {
            // arr[i+1] is found by XORing the current element with the encoded value
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        
        return arr;
    }
}
