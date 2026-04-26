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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left -right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = node.left == null ? 1 :  1 + getHeight(node.left);
        int right = node.right == null ? 1 :  1 + getHeight(node.right);
        return Math.max(left, right);
    }
}
