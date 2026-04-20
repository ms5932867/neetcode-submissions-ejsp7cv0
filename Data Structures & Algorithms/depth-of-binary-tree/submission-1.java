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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));
        int max = 1;
        while(!stk.isEmpty()) {
            Pair cur = stk.pop();
            max = Math.max(max, cur.level);
            if (cur.node.left != null) {
                stk.push(new Pair(cur.node.left, cur.level + 1));
            }
            if (cur.node.right != null) {
                stk.push(new Pair(cur.node.right, cur.level + 1));
            }
        }
        return max;
    }
    public class Pair {
        TreeNode node;
        int level;
        public Pair (TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
