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
    public int maxDepth(TreeNode root) {
        int count = 0;

        Queue<TreeNode> ue = new LinkedList<>();

        if (root == null)
            return count;

        ue.add(root);

        while (!ue.isEmpty()) {
            count++;

            int n = ue.size();

            for (int i = 0; i < n; i++) {
                TreeNode top = ue.poll();

                if (top.left != null)
                    ue.add(top.left);

                if (top.right != null)
                    ue.add(top.right);
            }
        }

        return count;
    }
}