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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null)
            return res;

        int level = -1;

        Queue<TreeNode> ue = new LinkedList<>();

        ue.add(root);

        while (!ue.isEmpty()) {
            int n = ue.size();
            List<Integer> li = new ArrayList<>();
            level++;

            for (int i = 0; i < n; i++) {
                TreeNode top = ue.peek();

                if (top.left != null)
                    ue.add(top.left);

                if (top.right != null)
                    ue.add(top.right);

                if (level % 2 != 0)
                    li.add(0, top.val);
                else
                    li.add(top.val);

                ue.poll();

            }

            res.add(li);

        }

        return res;
    }

}