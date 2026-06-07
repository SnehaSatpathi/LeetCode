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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        // Step 1: Build the tree and track all children
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;
            
            // Get or create parent node
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parentNode = nodeMap.get(parentVal);
            
            // Get or create child node
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode childNode = nodeMap.get(childVal);
            
            // Link parent to child
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            // Mark this node as a child
            children.add(childVal);
        }
        
        // Step 2: Find the root node (a parent that is not in the children set)
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        
        return null;
    }
}