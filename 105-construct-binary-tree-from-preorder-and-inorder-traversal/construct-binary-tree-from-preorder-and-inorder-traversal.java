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

        // Base case: if arrays are empty, the tree/subtree is null
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // The first element in preorder is always the root
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // Find where the root is located in the inorder array
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }

        // Slice arrays and recursively build left and right subtrees
        // Left subtree arrays
        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPre, leftIn);

        // Right subtree arrays
        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
