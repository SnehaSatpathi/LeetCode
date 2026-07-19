class Solution(object):
    def smallestSubsequence(self, s):
        """
        :type s: str
        :rtype: str
        """



        # Record the last occurrence index of each character
        last_index = {char: idx for idx, char in enumerate(s)}
        
        stack = []
        seen = set()
        
        # Iterate through the string
        for idx, char in enumerate(s):
            # Skip if the character is already in our result stack
            if char in seen:
                continue
                
            # Pop characters from stack if they are larger than the current character
            # AND they appear again later in the string
            while stack and stack[-1] > char and last_index[stack[-1]] > idx:
                removed_char = stack.pop()
                seen.remove(removed_char)
                
            # Push the current character to the stack and mark it as seen
            stack.append(char)
            seen.add(char)
            
        return "".join(stack)
       