/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode temp1 = p;
        TreeNode temp2 = q;

        return traverse(temp1, temp2);
    }

    private boolean traverse(TreeNode temp1, TreeNode temp2) {

        if (temp1 == null && temp2 == null)
            return true;
        else if (temp1 == null)
            return false;
        else if (temp2 == null)
            return false;

        if (temp1.val != temp2.val)
            return false;

        boolean left = traverse(temp1.left, temp2.left);
        boolean right = traverse(temp1.right, temp2.right);

        return (left && right);

    }
}