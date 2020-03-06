/**
*@auther Liam Watson
*Binary tree data structure
*This code was adpted from that of Hussein Suleman
*/
public class LSBT<T>{
    LSBSTNode<T> root;
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
   /**
	* 
	* Preorder is used from traversal
	*/ 
   public void preOrder ()
   {
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
