/**
*@auther Liam Watson
*Binary tree data structure
*This code was adpted from that of Hussein Suleman
*/
public class LSBT<T>{
    String inputString= new String();
    public LSBSTNode<T> root;
    int totalnodes = 0; //keeps track of the inorder number for horiz. scaling 
    int maxheight=0;//keeps track of the depth of the tree for vert. scaling
    /**
	* 
	* creates a null root
	*/ 
    public LSBT(){
        root = null;
    }
	/**
	* Prints a nodes value 
	* @param The node that is to be printed
	*/ 
    public void visit ( LSBSTNode<T> node )
   {
        System.out.println(node.data);
   }
 public int treeHeight(LSBSTNode<T> t){
	if(t==null) return -1;
          else return 1 + max(treeHeight(t.left),treeHeight(t.right));
    }
    public int max(int a, int b){
	  if(a>b) return a; else return b;
    }

    public void computeNodePositions() {
      int depth = 1;
      inorder_traversal(root, depth);
    }

//traverses tree and computes x,y position of each node, stores it in the node

    public void inorder_traversal(LSBSTNode<T> t, int depth) { 
      if (t != null) {
        inorder_traversal(t.left, depth + 1); //add 1 to depth (y coordinate) 
        t.xpos = totalnodes++; //x coord is node number in inorder traversal
        t.ypos = depth; // mark y coord as depth
        inorder_traversal(t.right, depth + 1);
	}
      }
   /**
	* 
	* Preorder is used from traversal
	*/ 
   public void preOrder(){
      preOrder (root);
   }
	/**
	*@param The node that will be used for traversal references 
	* 
	*/ 
   public void preOrder ( LSBSTNode<T> node )
   {
      if (node != null)
      {
        visit (node);	
        preOrder (node.getLeft ());
        preOrder (node.getRight ());
      } else if(node == null){
       System.out.println("preOder not working due to no data");
      }  
   }
}
