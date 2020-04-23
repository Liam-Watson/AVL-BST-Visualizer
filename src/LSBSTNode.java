/**Liam Watson
*Node class for a BST data structure
*Code was adapted from that created by Hussein Suleman
*/

public class LSBSTNode<dataType>{
    dataType data;
    LSBSTNode<dataType> left;
    LSBSTNode<dataType> right;
    int height;
    int xpos;  //stores x and y position of the node in the tree
    int ypos; 
	/**
	* A constructor used to assign values to instance variables 
	* @param Values to assign to instance variables
	*/ 
    public LSBSTNode (dataType d, LSBSTNode<dataType> l, LSBSTNode<dataType> r ){
        data = d;
        left = l;
        right = r;
        height = 0;
   }
	/**
	* @retrun LSBSTNode which is the left reference  
	* 
	*/ 
   LSBSTNode<dataType> getLeft () { return left; }
	/**
	* @return LSBSTNode which is the right reference 
	* 
	*/ 
   LSBSTNode<dataType> getRight () { return right; }
}
