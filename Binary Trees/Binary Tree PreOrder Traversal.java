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
/* Recursion */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        findPreOrder(root, res);

        return res;
    }

    private void findPreOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);

        findPreOrder(root.left, res);
        findPreOrder(root.right, res);

        return;
    }

}

/* Iteration */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        if (root == null)
            return res;

        stk.push(curr);

        while (!stk.isEmpty()) {
            TreeNode top = stk.pop();
            res.add(top.val);
            if (top.right != null)
                stk.push(top.right);
            if (top.left != null)
                stk.push(top.left);
        }

        return res;
    }
}

/* Morris Traversal */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        TreeNode curr = root;
        if (root == null)
            return res;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode last = curr.left;
                while (last.right != null && last.right != curr) {
                    last = last.right;
                }

                if (last.right == null) {
                    last.right = curr;
                    res.add(curr.val);
                    curr = curr.left;
                } else if (last.right == curr) {
                    last.right = null;
                    curr = curr.right;
                }
            }
        }

        return res;
    }

}
/* Time Complexity -O(N) */
/* Space Complexity - O(1) */