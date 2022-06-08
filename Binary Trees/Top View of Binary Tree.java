/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {

    class TreeNode {
        Node node;
        int line;

        TreeNode(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TreeNode> ue = new LinkedList<>();

        ue.add(new TreeNode(root, 0));

        while (!ue.isEmpty()) {
            Node top = ue.peek().node;
            int line = ue.peek().line;

            ue.poll();

            if (!map.containsKey(line))
                map.put(line, top.data);

            if (top.left != null)
                ue.add(new TreeNode(top.left, line - 1));

            if (top.right != null)
                ue.add(new TreeNode(top.right, line + 1));

        }

        for (int num : map.values())
            res.add(num);

        return res;

    }
}