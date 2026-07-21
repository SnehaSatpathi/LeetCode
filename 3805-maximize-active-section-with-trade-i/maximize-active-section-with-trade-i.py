class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        original_ones = s.count('1')
        
        zero_segments = []
        current_zero_len = 0
        
        for char in s:
            if char == '0':
                current_zero_len += 1
            else:
                if current_zero_len > 0:
                    zero_segments.append(current_zero_len)
                    current_zero_len = 0
                    
        if current_zero_len > 0:
            zero_segments.append(current_zero_len)
            
        if len(zero_segments) < 2:
            return original_ones
            
        max_gain = max(zero_segments[i] + zero_segments[i+1] for i in range(len(zero_segments) - 1))
        
        return original_ones + max_gain


        