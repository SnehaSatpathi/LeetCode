class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // While a collision scenario exists: 
            // Stack has a right-mover (positive) and current is a left-mover (negative)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(ast) > stack.peek()) {
                    // Current left-mover is larger, destroys stack top and keeps moving left
                    stack.pop();
                    continue;
                } else if (Math.abs(ast) == stack.peek()) {
                    // Both are same size, both destroy each other
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Stack top is larger, current asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }
            
            // If current asteroid wasn't destroyed, add it to stack
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
