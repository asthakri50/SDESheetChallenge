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

/* Iteration */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> ans = new Stack<>();

        stk.push(root);

        while (!stk.isEmpty()) {
            TreeNode top = stk.pop();
            ans.push(top.val);

            if (top.left != null)
                stk.push(top.left);

            if (top.right != null)
                stk.push(top.right);
        }

        // Reverse the res list

        while (!ans.isEmpty()) {
            res.add(ans.pop());
        }

        return res;
    }
}

/* Recursion */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        findPostOrder(root, res);

        return res;
    }

    private void findPostOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        findPostOrder(root.left, res);
        findPostOrder(root.right, res);

        res.add(root.val);

    }
}