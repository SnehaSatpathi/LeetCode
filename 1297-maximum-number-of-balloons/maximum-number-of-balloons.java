class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        

        for (char c : text.toCharArray()) {
            if (c == 'b') b++;
            else if (c == 'a') a++;
            else if (c == 'l') l++;
            else if (c == 'o') o++;
            else if (c == 'n') n++;
        }
        
        // Divide l and o by 2 as they appear twice in "balloon"
        l /= 2;
        o /= 2;
        
        // The bottleneck is the character with the lowest count
        int min1 = Math.min(b, a);
        int min2 = Math.min(l, o);
        int min3 = Math.min(min2, n);
        
        return Math.min(min1, min3);
    }
}


        
    
