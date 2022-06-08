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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftd = diameterOfBinaryTree(root.left);
        int rightd = diameterOfBinaryTree(root.right);

        int dist = findHeight(root.left) + findHeight(root.right);

        return Math.max(dist, Math.max(leftd, rightd));

    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

}