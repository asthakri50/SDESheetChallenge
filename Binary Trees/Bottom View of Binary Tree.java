class Solution {
    class TreeNode {
        Node node;
        int line;

        TreeNode(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TreeNode> ue = new LinkedList<>();

        ue.add(new TreeNode(root, 0));

        while (!ue.isEmpty()) {
            Node top = ue.peek().node;
            int line = ue.peek().line;
            map.put(line, top.data);

            ue.poll();

            if (top.left != null) {
                ue.add(new TreeNode(top.left, line - 1));
            }

            if (top.right != null) {
                ue.add(new TreeNode(top.right, line + 1));
            }
        }

        for (Integer num : map.values()) {
            res.add(num);
        }

        return res;
    }

}