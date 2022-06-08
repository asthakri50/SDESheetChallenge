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

    public int widthOfBinaryTree(TreeNode root) {

        // DFS Solution
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        return findMaxWidth(root, 0, 1, start, end);

    }

    public int findMaxWidth(TreeNode root, int level, int index, ArrayList<Integer> start, ArrayList<Integer> end) {
        if (root == null)
            return 0;

        if (start.size() == level) {
            start.add(index);
            end.add(index);
        } else
            end.set(level, index);

        int cur = end.get(level) - start.get(level) + 1;

        int left = findMaxWidth(root.left, level + 1, index * 2, start, end);
        int right = findMaxWidth(root.right, level + 1, index * 2 + 1, start, end);

        return Math.max(cur, Math.max(left, right));
    }
}