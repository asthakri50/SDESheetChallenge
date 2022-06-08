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

 /**Recursion**/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>() ;
        
        findInOrder(root, res) ;
        
        return res ;
    }
    
    private void findInOrder(TreeNode root , List<Integer> res) {
        if(root == null)
            return ;
        
        findInOrder(root.left, res ) ;
        
        res.add(root.val) ;
        
        findInOrder(root.right , res) ;
        
        return ;
    }
}

 /**Iteration**/
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>() ;
        
       Stack<TreeNode> stk = new Stack<>() ;
        
        //push all left nodes to stack
        TreeNode curr = root ;
        while(curr != null || !stk.isEmpty() ){
            while(curr != null){
            stk.push(curr) ;
            curr = curr.left ;
            }
        
        curr = stk.pop() ;
        res.add(curr.val) ;
        curr = curr.right ;
        
        }
        
        return res ;
        
    }
    
    
}


 /**Morris Traversal**/
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>() ;
        
        TreeNode curr = root ; 
        if(root == null)
            return res ;
        
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val) ;
                curr = curr.right ;
            }else{
                TreeNode last = curr.left ; 
                while(last.right != null && last.right != curr){
                    last = last.right ;
                } 
                
                if(last.right == null){
                    last.right = curr ;
                    curr = curr.left ;
                }else if(last.right == curr){
                    last.right = null ;
                    res.add(curr.val) ;
                    curr = curr.right ;
                }
            }
        }
        
        
        return res ;
        
    }
    
    
}