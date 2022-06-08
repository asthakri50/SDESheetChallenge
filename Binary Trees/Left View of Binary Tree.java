/*User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
    //Print the first node of level order traversal
    ArrayList<Integer> res = new ArrayList<>() ;
    findLeftView(root , 0 , res) ;
    
    return res ;
    
    
    }
    
    void findLeftView(Node root , int level , ArrayList<Integer> res) {
        if(root == null)
            return ;
            
        if(level == res.size() )
            res.add(root.data) ;
            
        
        findLeftView(root.left , level+1 , res) ;
        findLeftView(root.right , level+1 , res) ;
        
    return ;    
    }
}
