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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pstk = new Stack<>();
        pstk.push(p);
        Stack<TreeNode> qstk = new Stack<>();
        qstk.push(q);
        while (!pstk.isEmpty() && !qstk.isEmpty()) {
            TreeNode pcur = pstk.pop();
            TreeNode qcur = qstk.pop();
            if (pcur == null && qcur == null) {
                continue;
            } else if (pcur == null || qcur == null || pcur.val != qcur.val) {
                return false;
            }
            pstk.push(pcur.left);
            pstk.push(pcur.right);
            qstk.push(qcur.left);
            qstk.push(qcur.right);


        }
        return true;
    }
}
