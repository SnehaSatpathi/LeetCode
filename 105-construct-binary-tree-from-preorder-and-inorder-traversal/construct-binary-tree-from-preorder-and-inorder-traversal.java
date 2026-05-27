/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to find the root's index in the inorder array in O(1) time
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // A single-element array to track the current root in preorder across recursive calls
        int[] preIdx = new int[]{0}; 
        
        // Start the Divide and Conquer process
        return divideAndConquer(preorder, preIdx, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode divideAndConquer(int[] preorder, int[] preIdx, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        // BASE CASE- If the boundaries cross, this subtree is empty
        if (inStart > inEnd) {
            return null;
        }

        // DIVIDE- Pick the current root from preorder array and find its split point
        int rootVal = preorder[preIdx[0]];
        preIdx[0]++; // Advance to the next root element for subsequent calls
        
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal); // Get the midpoint

        //  CONQUER- Recursively solve the smaller subproblems
        // Build the left subtree using the elements to the left of the midpoint
        root.left = divideAndConquer(preorder, preIdx, inorderMap, inStart, rootIdx - 1);
        
        // Build the right subtree using the elements to the right of the midpoint
        root.right = divideAndConquer(preorder, preIdx, inorderMap, rootIdx + 1, inEnd);

        //  COMBINE- Return the constructed root node with its subtrees attached
        return root;
    }
}