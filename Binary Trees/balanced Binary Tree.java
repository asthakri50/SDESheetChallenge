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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true ;
        
        int left = findHeight(root.left) ;
        
        int right = findHeight(root.right) ;
        
        boolean  res = false ;
        
        if(Math.abs(left - right) <= 1)
            res = true ;
        
        return (isBalanced(root.left) && isBalanced(root.right) && res) ;
    }
    
    private int findHeight(TreeNode root){
        if(root == null)
            return 0 ;
        
        return Math.max(findHeight(root.left) , findHeight(root.right) ) + 1 ;
    }
}