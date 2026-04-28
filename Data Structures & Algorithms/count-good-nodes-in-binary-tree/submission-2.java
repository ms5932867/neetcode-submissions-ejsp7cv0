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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }
    private void dfs(TreeNode node, int curMax) {
        if (node == null) {
            return;
        }
        int prevMax = curMax;
        if (node.val >= prevMax) {
            cnt++;
            curMax = node.val;
        }
        dfs(node.left, curMax);
        dfs(node.right, curMax);
        if (node.val >= prevMax) {
            curMax = prevMax;
        }

    }
}
