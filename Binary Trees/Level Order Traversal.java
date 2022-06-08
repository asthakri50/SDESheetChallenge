/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*Iteration */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>() ;
        
        Queue<TreeNode> ue = new LinkedList<>() ;
        
        if(root == null)
            return res ;
        
        ue.add(root) ;
        
        while(! ue.isEmpty() ){
            int n = ue.size() ;
            List<Integer> li = new ArrayList<>() ;
            
            for(int i = 0 ; i < n ; i++){
                TreeNode top = ue.poll() ;
                li.add(top.val) ;
                
                if(top.left != null)
                    ue.add(top.left) ;
                
                if(top.right != null)
                    ue.add(top.right) ;
            }
            
            res.add(li) ;
        }
        
        return res ;
    }
}


/* Recursion- DFS Solution*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>() ;
        
        findLevelOrder(res , root , 0) ;
        
        return res ;
    }
    
    private void findLevelOrder(List<List<Integer>> res , TreeNode root , int height){
        if(root == null)
            return ;
        
        if(res.size() == height)
            res.add(new ArrayList<Integer>() );
        
        res.get(height).add(root.val) ;
        
        findLevelOrder(res , root.left , height+1) ;
        
        findLevelOrder(res , root.right , height+1 ) ;
        
        return ;
    }
}