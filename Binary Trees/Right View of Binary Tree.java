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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if (root == null)
            return li;

        Queue<TreeNode> ue = new LinkedList<>();

        ue.add(root);

        while (!ue.isEmpty()) {
            int n = ue.size();

            for (int i = 1; i <= n; i++) {
                TreeNode top = ue.poll();
                if (i == n)
                    li.add(top.val);

                if (top.left != null)
                    ue.add(top.left);

                if (top.right != null)
                    ue.add(top.right);
            }
        }

        return li;
    }
}

/* Recursion */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        findRightView(root, 0, res);

        return res;

    }

    private void findRightView(TreeNode root, int level, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (level == res.size())
            res.add(root.val);

        findRightView(root.right, level + 1, res);
        findRightView(root.left, level + 1, res);

        return;
    }

}