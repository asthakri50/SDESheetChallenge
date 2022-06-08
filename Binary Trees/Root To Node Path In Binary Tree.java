/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<>();

        boolean val = findPath(A, B, res);

        int n = res.size();

        for (int i = 0; i < n / 2; i++) {
            int temp1 = res.get(i);
            int temp2 = res.get(n - i - 1);
            res.set(i, temp2);
            res.set(n - i - 1, temp1);
        }

        return res;

    }

    private boolean findPath(TreeNode A, int B, ArrayList<Integer> res) {
        if (A == null)
            return false;

        if (A.val == B) {
            res.add(A.val);
            return true;
        }

        boolean left = findPath(A.left, B, res);

        boolean right = findPath(A.right, B, res);

        if (left == true || right == true) {
            res.add(A.val);
            return true;
        }

        return false;

    }
}
